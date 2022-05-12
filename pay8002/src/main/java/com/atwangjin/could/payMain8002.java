package com.atwangjin.could;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author WangJin
 * @create 2022-04-19 22:47
 */
@SpringBootApplication
@EnableEurekaClient
public class payMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(payMain8002.class,args);
    }
}
