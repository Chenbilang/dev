package com.example.demo22.config;

import com.example.demo22.pojo.Behavior;
import com.example.demo22.pojo.Fly;
import org.springframework.context.annotation.Bean;

public class AutoFlyConfig {
    {
        System.out.println("实例。。。");
    }
    @Bean
    public Behavior behavior() {
        return new Fly();
    }
}
