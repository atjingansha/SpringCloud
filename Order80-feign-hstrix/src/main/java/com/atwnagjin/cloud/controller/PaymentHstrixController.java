package com.atwnagjin.cloud.controller;

import com.atwnagjin.cloud.service.PaymentHstrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-04-27 21:43
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //次注解用于配置全局fallback
public class PaymentHstrixController {

    @Autowired
    private PaymentHstrixService paymentHstrixService;

    @GetMapping("/consumer/payment/hystirx/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
      String result=  paymentHstrixService.payment_ok(id);
      return  result;
    }


    /**
     * 客户端添加服务降级保护
     * @param id
     * @return
     */

//    @HystrixCommand(fallbackMethod = "payment_sleepHandler",commandProperties = {
//            //规定在多少毫秒之内完成,超过时间则不再等待
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystirx/error/{id}")
    public String payment_sleep(@PathVariable("id") Integer id){

//        int num=1/0;
        String result=    paymentHstrixService.payment_sleep(id);
        return  result;
    }

    public String payment_sleepHandler(@PathVariable("id") Integer id){
        return "消费者80对方系统繁忙请过会再试试id:" + id + "\t" + "🐀🐂🐅🐇🐉🐍🐎🐏🐒🐓🐕🐖" ;
    }

    //下面是全局fallback一旦有方法出现异常统一都可以使用此方法处理
    public String payment_Global_FallbackMethod(){
        return "消费者80全局fallback:";
    }

}
