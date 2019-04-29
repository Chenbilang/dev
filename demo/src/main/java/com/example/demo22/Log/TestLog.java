package com.example.demo22.Log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志Aop
 * @author chenbilang
 */
@Aspect
@Component
public class TestLog {
        private static final Logger logger = LoggerFactory.getLogger(TestLog.class);
        private static final Logger logger2 = LoggerFactory.getLogger("a");

    /**
     * 环绕增强，相当于MethodInterceptor
     */
       @AfterReturning(value = "execution(* com.example.demo22.contorller.LabelContorller.*(..))", returning = "result")
       public void afterBatchDelete(JoinPoint joinPoint, Object result) throws InterruptedException {
            System.out.println("打日志");

            logger2.info("this is info:"+result);
            logger.error("this is error:"+result);
            logger2.debug("this is debug:"+result);
        }


}
