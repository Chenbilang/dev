package com.example.demo22.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20);
        threadPoolTaskExecutor.setMaxPoolSize(200);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.setKeepAliveSeconds(200);
        threadPoolTaskExecutor.setThreadNamePrefix("oKong-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;

    }
}
