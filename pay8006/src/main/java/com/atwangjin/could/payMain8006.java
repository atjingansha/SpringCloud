package com.atwangjin.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-04-25 16:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class payMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(payMain8006.class,args);
    }
}
