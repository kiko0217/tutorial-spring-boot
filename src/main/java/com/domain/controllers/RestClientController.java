package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.UserRestClientData;
import com.domain.services.RestClientService;

@RestController
@RequestMapping("/api/rest-client")
public class RestClientController {

    @Autowired
    private RestClientService restClientService;

    @GetMapping("/string/{id}")
    public ResponseEntity<String> findUserString(@PathVariable("id") int id){
        return restClientService.getUserString(id);
    }
    
    @GetMapping("/dto/{id}")
    public ResponseEntity<UserRestClientData> findUserDto(@PathVariable("id") int id){
        return restClientService.getUserDto(id);
    }
    
    @GetMapping
    public ResponseEntity<UserRestClientData[]> findUserAll(){
        return restClientService.getUserAll();
    }
}
