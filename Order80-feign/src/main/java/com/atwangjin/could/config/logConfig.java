package com.atwangjin.could.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置feign详细日志
 * @author WangJin
 * @create 2022-04-26 22:44
 */
@Configuration
public class logConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
