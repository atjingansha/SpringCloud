package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-04-23 20:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class order80ZKMain {

    public static void main(String[] args) {
        SpringApplication.run(order80ZKMain.class,args);
    }
}
