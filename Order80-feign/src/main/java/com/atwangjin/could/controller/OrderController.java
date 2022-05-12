package com.atwangjin.could.controller;

import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import com.atwangjin.could.service.PayFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJin
 * @create 2022-04-26 21:17
 */

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PayFeignService payFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult payment = payFeignService.getPayment(id);

        return payment;
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return payFeignService.paymentFeignTimeOut();
    }
}
