package com.mp.springcoredemo.config;

import com.mp.springcoredemo.common.Coach;
import com.mp.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

//    add custom bean id
//    @Bean("testId")
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
