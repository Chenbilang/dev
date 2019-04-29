package com.example.demo22.aop;

import com.example.demo22.constants.CommonConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 对标签增加，删除，更改方法进行拦截，并删除redis缓存数据
 * @author chenbilang
 */
@Aspect
@Component
public class RedisAop {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 在标签增加，删除，更改方法执行之前删除redis缓存数据
     */
    @AfterReturning(value = "execution(* com.example.demo22.service.impl.LabelServieImpl.add(..))||" +
            "execution(* com.example.demo22.service.impl.LabelServieImpl.deleteById(..))||" +
            "execution(* com.example.demo22.service.impl.LabelServieImpl.update(..))")
    public void beforeUpdate()  {
        System.out.println("删除redis数据");
        Set labelist = redisTemplate.opsForSet().members("labelset");
        for (Object object:labelist){
            redisTemplate.delete(CommonConstant.REIDS_KEY+"_"+object);
        }
    }
}
