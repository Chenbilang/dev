package com.example.demo22.task;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author lijian
 * @version 0.0.1
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TaskTest {

    private static final Logger logger = LoggerFactory.getLogger(TaskTest.class);
    /**
     *
     */
    @Scheduled(cron = "0/60 * * * * ?")
    public void updateActivityOnline() {

        System.out.println("hello");

    }

}
