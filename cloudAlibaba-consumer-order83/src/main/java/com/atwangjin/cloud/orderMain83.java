package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-07 23:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class orderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(orderMain83.class,args);
    }
}
