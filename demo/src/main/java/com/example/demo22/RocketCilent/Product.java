package com.example.demo22.RocketCilent;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;

public class Product {
    private String gruop_id;
    private String InstanceName;
    private String addr;
    private DefaultMQProducer producer = new DefaultMQProducer("rocket-test2");
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGruop_id() {
        return gruop_id;
    }

    public void setGruop_id(String gruop_id) {
        this.gruop_id = gruop_id;
    }

    public String getInstanceName() {
        return InstanceName;
    }

    public void setInstanceName(String instanceName) {
        InstanceName = instanceName;
    }
    public  DefaultMQProducer getProducer(){
        producer.setNamesrvAddr(this.addr);
        producer.setInstanceName(this.InstanceName);
        return producer;
    }
}
