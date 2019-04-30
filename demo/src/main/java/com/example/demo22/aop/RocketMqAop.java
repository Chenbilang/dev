package com.example.demo22.aop;



import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageExt;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.example.demo22.RocketCilent.Product;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Aspect
@Component
public class RocketMqAop {
    private final Logger logger=LoggerFactory.getLogger(RocketMqAop.class);
    @AfterReturning(value = "execution(* com.example.demo22.service.impl.LabelServieImpl.add(..))||" +
            "execution(* com.example.demo22.service.impl.LabelServieImpl.deleteById(..))" )
    public void beforeAddAndDelete(){
        System.out.println("前置通知");
        String message="add and delete data";
        DefaultMQProducer producer = new DefaultMQProducer("rocket-test");
        producer.setNamesrvAddr("192.168.5.114:9876");
        producer.setInstanceName("producer");
        //调用start()方法启动一个producer实例
        try {
            producer.start();
        } catch (MQClientException e1) {
            e1.printStackTrace();
        }
//        Product product=new Product();
//        product.setAddr("192.168.5.114:9876");
//        product.setInstanceName("product");
//        DefaultMQProducer producer = product.getProducer();
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        Message msg = null;
        try {
            msg = new Message("TopicTest",// topic
                    "TagA",// tag
                    "add and delete data".getBytes(RemotingHelper.DEFAULT_CHARSET)// body
            );
            try {
                SendResult sendResult = producer.send(msg);
                System.out.print(msg + "\n");
                System.out.println(sendResult.getSendStatus());
            } catch (MQClientException e1) {
                e1.printStackTrace();
            } catch (RemotingException e1) {
                e1.printStackTrace();
            } catch (MQBrokerException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        producer.shutdown();
    }
    @Before(value = "execution(* com.example.demo22.service.impl.LabelServieImpl.add(..))||" +
            "execution(* com.example.demo22.service.impl.LabelServieImpl.deleteById(..))" )
    public void afterAddAndDelete(){
        System.out.println("后置通知");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rocket-test2");
        consumer.setNamesrvAddr("192.168.5.114:9876");
        consumer.setInstanceName("consumer");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        try {
            consumer.subscribe("TopicTest", "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //设置一个Listener，主要进行消息的逻辑处理
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                if(msgs!=null){

                    logger.info("func[{}]  desc[add and delete data]",
                            new Object[]{Thread.currentThread().getStackTrace()[1].getMethodName()});
                }
                for (MessageExt msg : msgs) {
                    System.out.println("接收到通知");
                    System.out.println(new String(msg.getBody()));
                }

                //返回消费状态
                //CONSUME_SUCCESS 消费成功
                //RECONSUME_LATER 消费失败，需要稍后重新消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //调用start()方法启动consumer
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        System.out.println("Consumer Started.");
    }

}



