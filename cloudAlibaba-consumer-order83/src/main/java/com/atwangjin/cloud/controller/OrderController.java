package com.atwangjin.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangJin
 * @create 2022-05-07 23:36
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${service-url.nacos-user-service}")
    private String serverUrl;




    @GetMapping("/consumer/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
    //    ServiceInstance serviceInstance = loadBalancerClient.choose(serverUrl);

        return restTemplate.getForObject(serverUrl+"/nacos/"+id,String.class);

    }
}
