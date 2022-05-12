package com.atwangjin.cloud.controller;

import com.atwangjin.cloud.service.paymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-04-27 20:21
 */
@RestController
@Slf4j
public class paymentController {

    @Autowired
    private paymentService paymentService;

    @Value("${server.port}")
  private   String ServerPort;


    @GetMapping("/payment/hystirx/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){

        String result = paymentService.payment_Ok(id);

        log.info("result="+result);

        return result;
    }



    @GetMapping("/payment/hystirx/error/{id}")
    public String payment_sleep(@PathVariable("id") Integer id){

        String result = paymentService.payment_sleep(id);

        log.info("result="+result);

        return result;
    }


    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String reuslt = paymentService.paymentCircuitBreaker(id);
        log.info(reuslt);

        return reuslt;


    }
}
