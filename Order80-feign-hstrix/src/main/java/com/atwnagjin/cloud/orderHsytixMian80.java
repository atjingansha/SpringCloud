package com.atwnagjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author WangJin
 * @create 2022-04-27 21:36
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class orderHsytixMian80 {

    public static void main(String[] args) {
        SpringApplication.run(orderHsytixMian80.class,args);
    }
}
