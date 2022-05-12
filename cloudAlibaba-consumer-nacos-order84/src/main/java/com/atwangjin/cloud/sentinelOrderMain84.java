package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author WangJin
 * @create 2022-05-10 21:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class sentinelOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(sentinelOrderMain84.class,args);
    }
}
