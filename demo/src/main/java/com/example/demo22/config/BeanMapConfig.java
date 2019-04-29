package com.example.demo22.config;

import com.example.demo22.Factory.BeanMap;
import com.example.demo22.pojo.Fly;
import com.example.demo22.pojo.Walk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanMapConfig {
    @Autowired
    private Fly fly;
    @Autowired
    private Walk walk;
    @Bean
    public BeanMap beanMap(){
        BeanMap beanMap=new BeanMap();
//        beanMap.put("fly",new Fly());
//        beanMap.put("walk",new Walk());
        beanMap.put("fly",fly);
        beanMap.put("walk",walk);
        return beanMap;
    }

}
