package com.example.demo22.pojo;

import com.example.demo22.Factory.BeanMap;
import com.example.demo22.dao.LabelMapper;
import com.example.demo22.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fly implements Behavior{
    @Autowired
    private LabelMapper labelMapper;


    @Override

    public void behavior() {

        System.out.println("fly.......");
    }

    @Override
    public SysLabel getSysLabel() {
        SysLabel label=labelMapper.selectByPrimaryKey(52L);
        return label;
    }


}
