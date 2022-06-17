package com.domain.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TestService implements HealthIndicator {

    @Override
    public Health health() {
        if(isTestHealthGoog()){
            return Health
                    .up()
                    .withDetail("TestService", "Test is running")
                    .build();
        }
        return Health
                .down()
                .withDetail("TestService", "Test is not available")
                .build();
    }

    public boolean isTestHealthGoog(){
        return true;
    }
    
}
