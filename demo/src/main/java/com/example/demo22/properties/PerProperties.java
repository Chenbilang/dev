package com.example.demo22.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@PropertySource("classpath:test.properties")
@Component
@ConfigurationProperties(prefix = "per")
public class PerProperties {
    private String name;
    private String age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
