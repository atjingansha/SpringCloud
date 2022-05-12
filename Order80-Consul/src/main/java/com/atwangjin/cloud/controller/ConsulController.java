package com.atwangjin.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangJin
 * @create 2022-04-25 18:00
 */
@RestController
@Slf4j
public class ConsulController {

    private static final String URL="http://pay-service";


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public  String ConsulOrder(){
      String result=restTemplate.getForObject(URL+"/payment/consul",String.class);

      return result;
    }
}
