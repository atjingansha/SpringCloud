package com.atwangjin.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author WangJin
 * @create 2022-04-27 20:20
 */
@Service
public class paymentService {


    /**
     * 模拟正常访问没有异常
     * @param id
     * @return
     */
    public String payment_Ok(Integer id){

        return "线程池"+Thread.currentThread().getName()+"  payment_OK,id="+id+"\t"+"😀正确";

    }

    /**
     * 模拟复杂业务逻辑程序
     * @param id
     * @return
     */
//服务降级注解
    @HystrixCommand(fallbackMethod = "payment_sleepHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String payment_sleep(Integer id) {

        int time = 3;
//        int num=10/0;   //模拟错误
        try {TimeUnit.SECONDS.sleep(time);} catch (InterruptedException e) {e.printStackTrace();}
        return "线程池" + Thread.currentThread().getName() + "  payment_error,id=" + id + "\t" + "💀正确" + "耗时" + time + "秒";

    }

    /**
     * 上面方法出现问题后才会调用此方法
     * @param id
     * @return
     */
    public String payment_sleepHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + " 系统繁忙请过会再试试id:" + id + "\t" + "🐀🐂🐅🐇🐉🐍🐎🐏🐒🐓🐕🐖" ;
    }


//之后代码为服务熔断
@HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间范围,单位毫秒
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") //超时时间
})
public String paymentCircuitBreaker(Integer id) {
    if (id < 0) {
        throw new RuntimeException("******id 不能负数");
    }
    String serialNumber = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
}

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能负数或超时或自身错误，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }


}
