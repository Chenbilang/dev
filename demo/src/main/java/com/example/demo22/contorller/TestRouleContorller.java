package com.example.demo22.contorller;

import com.example.demo22.Factory.BeanMap;
import com.example.demo22.Factory.BehaviorFactory;
import com.example.demo22.Util.SpringUtil;
import com.example.demo22.pojo.Behavior;
import com.example.demo22.pojo.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestRouleContorller {
    @Autowired
    private BeanMap beanMap;
    @RequestMapping("/test/*/{behavior}")
    public Object testAntStyleWithPathVariable(@PathVariable String behavior) {
//        Behavior behavior1 = BehaviorFactory.getBehavior(behavior);
//        behavior1.behavior();
        Behavior behavior1= (Behavior) beanMap.get(behavior);
        return behavior1.getSysLabel();
    }

}
