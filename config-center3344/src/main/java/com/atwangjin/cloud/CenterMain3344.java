package com.atwangjin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author WangJin
 * @create 2022-05-03 18:50
 */

@SpringBootApplication
@EnableConfigServer
public class CenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CenterMain3344.class,args);
    }
}
