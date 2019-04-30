package com.example.demo22.config;

import com.example.demo22.pojo.Behavior;
import com.example.demo22.pojo.Fly;
import com.example.demo22.pojo.Person;
import com.example.demo22.pojo.Walk;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConditionalOnClass({Fly.class})
////@ConditionalOnProperty(name = "person.enable",havingValue = "true")
//@ConditionalOnProperty(prefix = "person",name = "enable",havingValue = "true")
public class ConditionalOnClassConfig {
//    @Bean
    public Person person(){
        Person person=new Person();
        person.setBehavior(behavior());
        return person;
    }
//    @Bean
    public Behavior behavior(){
        return new Fly();
    }
}
