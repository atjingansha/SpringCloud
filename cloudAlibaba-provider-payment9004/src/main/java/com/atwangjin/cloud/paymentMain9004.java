package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-10 21:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class paymentMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(paymentMain9004.class,args);
    }
}
