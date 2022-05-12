package com.atwangjin.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-05-06 18:33
 */
@RestController

@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public  void input(Message<String> message){

    log.info("消费者1号,------>收到的消息"+message.getPayload()+"\t   port:" +serverPort);

    }
}
