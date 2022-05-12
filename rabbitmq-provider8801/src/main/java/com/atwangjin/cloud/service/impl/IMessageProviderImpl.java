package com.atwangjin.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import com.atwangjin.cloud.service.IMessageProvider;

import java.util.UUID;

/**
 * @author WangJin
 * @create 2022-05-06 17:52
 */
//@Service("iMessageProvider")   此处并不是传统的service而是与rabbitmq使用的所以不使用@Service注解

@EnableBinding(Source.class)   //定义一个消息生产者的发送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道


    @Override
    public String send() {

        String serial= UUID.randomUUID().toString().replace("-","");

        output.send(MessageBuilder.withPayload(serial).build());

        log.info("******serial="+serial);
        return null;
    }
}
