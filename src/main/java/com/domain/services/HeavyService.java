package com.domain.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HeavyService {
    @Cacheable("data")
    public String getSomeData() {
        simulateSlowProcess();
        return "I get the data!!";
    }

    public void simulateSlowProcess() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
