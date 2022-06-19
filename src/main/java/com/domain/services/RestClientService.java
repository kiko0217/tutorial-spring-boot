package com.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.dto.UserRestClientData;

@Service
public class RestClientService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getUserString(int id){
        return restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/users/" + id, String.class);
    }

    public ResponseEntity<UserRestClientData> getUserDto(int id){
        UserRestClientData user = restTemplate
                .getForObject("https://jsonplaceholder.typicode.com/users/" + id, UserRestClientData.class);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserRestClientData[]> getUserAll() {
        return restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/users/", UserRestClientData[].class);
    }
}
