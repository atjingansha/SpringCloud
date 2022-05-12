package com.atwangjin.could.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author WangJin
 * @create 2022-04-25 17:17
 */
@RestController
public class paymentController {



    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud  consul注册中心: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
