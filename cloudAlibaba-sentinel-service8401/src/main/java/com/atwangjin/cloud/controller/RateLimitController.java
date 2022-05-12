package com.atwangjin.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atwangjin.cloud.myhandler.CustomerBlockHandler;
import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-05-10 20:16
 */
@RestController
@Slf4j
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    /*
 [
    {
        "resource":"/rateLimit/byUrl",   资源名称
        "limitApp":"default",  来源应用
        "grade":1,     阈值类型,0表示线程数,1表示QPS
        "count":1, 单机阈值
        "strategy":0,     流控模式,0表示直接,1表示关联,2表示链路
        "controlBehavior":0,   流控效果,0表示快速失败,1表示Warm up,2表示排队等待
        "clusterMode":false   是否集群
    }
]
     */


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }

}
