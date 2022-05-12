package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-10 21:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class paymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain9003.class,args);
    }
}
