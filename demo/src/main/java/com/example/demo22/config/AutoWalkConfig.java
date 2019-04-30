package com.example.demo22.config;

import com.example.demo22.pojo.Behavior;
import com.example.demo22.pojo.Fly;
import com.example.demo22.pojo.Walk;
import org.springframework.context.annotation.Bean;

public class AutoWalkConfig {
    @Bean
    public Behavior behavior() {
        return new Walk();
    }
}
