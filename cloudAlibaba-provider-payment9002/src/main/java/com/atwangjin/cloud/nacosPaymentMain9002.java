package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author WangJin
 * @create 2022-05-07 23:19
 */

@SpringBootApplication
@EnableDiscoveryClient
public class nacosPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(nacosPaymentMain9002.class,args);
    }
}
