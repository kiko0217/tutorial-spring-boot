package com.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.dto.UserRestClientData;

@Service
public class RestClientService {
    private static String restLink = "https://jsonplaceholder.typicode.com/users/"; 
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getUserString(int id){
        return restTemplate
                .getForEntity(restLink + id, String.class);
    }

    public ResponseEntity<UserRestClientData> getUserDto(int id){
        UserRestClientData user = restTemplate
                .getForObject(restLink + id, UserRestClientData.class);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserRestClientData[]> getUserAll() {
        return restTemplate
                .getForEntity(restLink, UserRestClientData[].class);
    }
}
