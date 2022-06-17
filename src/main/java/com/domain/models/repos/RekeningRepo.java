package com.domain.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.Rekening;

public interface RekeningRepo extends CrudRepository<Rekening, Long>{
    public Rekening findByNorek(String norek);
}
