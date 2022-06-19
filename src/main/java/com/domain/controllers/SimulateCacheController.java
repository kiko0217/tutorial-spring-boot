package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.services.HeavyService;

@RestController
@RequestMapping("/api/cache")
public class SimulateCacheController {
    @Autowired
    private HeavyService heavyService;

    @GetMapping
    public String getData() {
        return heavyService.getSomeData();
    }
}
