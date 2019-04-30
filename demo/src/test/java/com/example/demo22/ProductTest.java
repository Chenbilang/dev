package com.example.demo22;




import com.aliyun.openservices.ons.api.*;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.ons.model.v20190214.OnsTopicListRequest;
import com.aliyuncs.ons.model.v20190214.OnsTopicListResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class ProductTest {
    @Test
    public void TestAPI() throws ClientException {
        String regionId = "cn-shenzhen";
        /**
         *鉴权使用的 AccessKeyId，由阿里云管理控制台获取
         */
        String accessKey = "LTAIxUEy0qQsj26X";
        /**
         *鉴权使用的 AccessKeySecret，由阿里云管理控制台获取
         */
        String secretKey = "UbxYk4z6TgSQAoROxTX3e42FQvJSdm";

        IClientProfile profile= DefaultProfile.getProfile(regionId,accessKey,secretKey);
        IAcsClient iAcsClient= new DefaultAcsClient(profile);
        //构造 Request 对象：这里以 TopicList 接口为例子，不同的 API 接口构造不同的 Request 对象
        OnsTopicListRequest request = new OnsTopicListRequest();
        request.setPreventCache(System.currentTimeMillis()); //当前时间戳
        OnsTopicListResponse response = iAcsClient.getAcsResponse(request);
        System.out.println(JSON.toJSONString(response));

    }

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        // 您在控制台创建的 Group ID
        properties.put(PropertyKeyConst.GROUP_ID, "Producer");
//        properties.put(PropertyKeyConst.ProducerId, "PID_ACT_LHWPTProducer");

        // 鉴权用 AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey,"LTAIxUEy0qQsj26X");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "UbxYk4z6TgSQAoROxTX3e42FQvJSdm");
        // 设置 TCP 接入域名，进入控制台的实例管理页面，在页面上方选择实例后，在实例信息中的“获取接入点信息”区域查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR,"192.168.5.114:9876");

        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();
        //循环发送消息
        for(int i=0;i<=5;i++){
            Message msg = new Message( //
                    // 在控制台创建的 Topic，即该消息所属的 Topic 名称
                    "TopicTest",
                    // Message Tag,
                    // 可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在消息队列 RocketMQ 服务器过滤
                    "TagA",
                    // Message Body
                    // 任何二进制形式的数据， 消息队列 RocketMQ 不做任何干预，
                    // 需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    "Hello MQ".getBytes());
            // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过控制台查询消息并补发
            // 注意：不设置也不会影响消息正常收发
            msg.setKey("ORDERID_100");
            // 发送消息，只要不抛异常就是成功
            // 打印 Message ID，以便用于消息发送状态查询
            SendResult sendResult = producer.send(msg);
            System.out.println("Send Message success. Message ID is: " + sendResult.getMessageId());
        }
        Thread.sleep(3000);
        producer.shutdown();
    }
}
