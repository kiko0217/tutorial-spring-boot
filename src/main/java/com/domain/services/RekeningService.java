package com.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.exceptions.InvalidDataException;
import com.domain.exceptions.NotFoundDataException;
import com.domain.models.entities.Rekening;
import com.domain.models.repos.RekeningRepo;

@Service
public class RekeningService {
    
    @Autowired
    private RekeningRepo rekeningRepo;

    public Rekening create(Rekening rekening){
        return rekeningRepo.save(rekening);
    }

    public Iterable<Rekening> findAll() {
        return rekeningRepo.findAll();
    }

    @Transactional
    public void transfer(String norekSource, String norekDestination, double amount){
        Rekening rekeningSource = rekeningRepo.findByNorek(norekSource);
        if(rekeningSource == null){
            throw new NotFoundDataException("Nomer Rekening : "+norekSource+" not found");
        }
        if(rekeningSource.getSaldo()<amount){
            throw new InvalidDataException("Saldo less then "+amount);
        }
        rekeningSource.setSaldo(rekeningSource.getSaldo()-amount);
        rekeningRepo.save(rekeningSource);

        Rekening rekeningDestination = rekeningRepo.findByNorek(norekDestination);
        if(rekeningDestination == null){
            throw new NotFoundDataException("Nomer Rekening : "+norekDestination+" not found");
        }
        rekeningDestination.setSaldo(rekeningDestination.getSaldo()+amount);
        rekeningRepo.save(rekeningDestination);
    }
}
