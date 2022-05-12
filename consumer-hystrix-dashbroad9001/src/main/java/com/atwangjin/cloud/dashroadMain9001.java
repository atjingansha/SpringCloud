package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author WangJin
 * @create 2022-04-28 20:37
 */
@SpringBootApplication
@EnableHystrixDashboard

public class dashroadMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(dashroadMain9001.class,args);
    }



}
