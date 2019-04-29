package com.example.demo22.pojo;

import com.example.demo22.dao.LabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Walk implements Behavior {

    @Autowired
    private LabelMapper labelMapper;

    public Walk() {
        System.out.println("创建Walk实例。。。。");
    }

    @Override
    public void behavior() {
        System.out.println("walk.......");
    }
    @Override
    public SysLabel getSysLabel() {
        SysLabel label=labelMapper.selectByPrimaryKey(52L);
        return label;
    }
}
