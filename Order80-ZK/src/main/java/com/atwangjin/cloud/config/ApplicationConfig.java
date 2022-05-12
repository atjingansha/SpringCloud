package com.atwangjin.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangJin
 * @create 2022-04-23 20:49
 */

@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced  //开启负载均衡
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
