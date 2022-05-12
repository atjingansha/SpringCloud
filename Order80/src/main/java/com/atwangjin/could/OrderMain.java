package com.atwangjin.could;

import com.atwangjin.myruler.MySelf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @author WangJin
 * @create 2022-04-19 18:09
 */

@SpringBootApplication
@EnableEurekaClient

//@RibbonClient(name = "PAY-SERVICE",configuration = MySelf.class)   //改为自己定义或者替换Ribbon的规则
public class OrderMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
