package com.mp.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Constructor " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println("In doStartupStuff() " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("In doCleanupStuff() " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
