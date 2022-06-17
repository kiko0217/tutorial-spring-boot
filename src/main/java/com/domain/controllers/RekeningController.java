package com.domain.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.RekeningData;
import com.domain.dto.ResponseData;
import com.domain.dto.TransferData;
import com.domain.models.entities.Rekening;
import com.domain.services.RekeningService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/rekening")
public class RekeningController {
    
    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Rekening>> create(@Valid @RequestBody RekeningData rekeningData, Errors errors) {
        ResponseData<Rekening> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Rekening rekening = modelMapper.map(rekeningData, Rekening.class);
        responseData.setStatus(true);
        responseData.setPayload(rekeningService.create(rekening));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Iterable<Rekening>>> findAll(){
        ResponseData<Iterable<Rekening>> responseData = new ResponseData<>();
        responseData.setStatus(true);
        responseData.setPayload(rekeningService.findAll());
        return ResponseEntity.ok(responseData);
    }

    @PostMapping(value="/transfer")
    public ResponseEntity<ResponseData<String>> transferData(@RequestBody TransferData transferData) {
        ResponseData<String> responseData = new ResponseData<>();
        rekeningService.transfer(transferData.getNorekSource(), transferData.getNorekDestination(), transferData.getAmount());
        responseData.setStatus(true);
        responseData.setPayload("Succces tranfer");
        return ResponseEntity.ok(responseData);
    }
}
