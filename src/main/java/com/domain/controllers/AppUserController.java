package com.domain.controllers;

import com.domain.dto.AppUserData;
import com.domain.dto.ResponseData;
import com.domain.models.entities.AppUser;
import com.domain.services.AppUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData) {
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        responseData.setPayload(appUserService.registerAppUser(appUser));
        responseData.setStatus(true);
        responseData.getMessages().add("AppUser saved!");
        return ResponseEntity.ok(responseData);
    }
}
