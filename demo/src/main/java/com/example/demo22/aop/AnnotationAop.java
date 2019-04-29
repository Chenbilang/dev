package com.example.demo22.aop;

import com.example.demo22.annotation.Test;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class AnnotationAop {

    @Around(value = "execution(* com.example.demo22.annotation.*.*(..))")
    public void AnnotationTest(JoinPoint joinPoint) throws NoSuchMethodException {


        Annotation[] annotations = joinPoint.getSignature().getDeclaringType().getMethod("Test").getAnnotations();


        for(Annotation annotation : annotations){
            Test test=(Test)annotation;
            int value=test.value();
            String name=test.name();
            System.out.println(name+":"+value);
        }

    }
}
