package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-07 23:06
 */

@SpringBootApplication
@EnableDiscoveryClient
public class nacosPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(nacosPaymentMain9001.class,args);
    }
}
