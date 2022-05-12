package com.atwangjin.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-05-08 14:08
 */
@RestController
@Slf4j
@RefreshScope //支持Nacos的动态刷新功能
public class configController {


    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
