package com.example.demo22;

import com.example.demo22.properties.PerProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
//@PropertySource("classpath:application.yml")

public class ValueTest {
    @Value("${per.name}")
    private String name;
    @Autowired
    private PerProperties perProperties;
    @Test
    public void testValue(){
        System.out.println("name:"+name);
    }
    @Test
    public void testPerProperties(){
        System.out.println("age:"+perProperties.getAge()+"\nname:"+perProperties.getName());
    }

   @Test
    public void Test(){
       Calendar calendar = Calendar.getInstance();
       calendar.set(Calendar.HOUR_OF_DAY, 0);
       calendar.set(Calendar.MINUTE, 0);
       calendar.set(Calendar.SECOND, 0);
       calendar.set(Calendar.MILLISECOND, 0);
       System.out.println(calendar.getTime());
   }
}
