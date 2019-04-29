package com.example.demo22.contorller;


import com.example.examplespringbootstarter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestModule {


    @Autowired
    private HelloService helloService;

    @GetMapping("/input")
    public String input(String word){

        return helloService.haloHello();
    }

}
