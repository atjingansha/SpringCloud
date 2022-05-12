package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-04-23 19:56
 */

@SpringBootApplication
@EnableDiscoveryClient  //该注解用于zookeeper或consul作为服务注册中心时使用
public class payMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(payMain8004.class,args);
    }
}
