package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-09 21:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class sentielMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(sentielMain8401.class,args);
    }
}
