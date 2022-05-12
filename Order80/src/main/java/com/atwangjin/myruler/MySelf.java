package com.atwangjin.myruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自己定义或者替换Ribbon的规则,不能放到ComponentScan可以扫描到的包下
 * @author WangJin
 * @create 2022-04-26 19:37
 */
@Configuration
public class MySelf {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
