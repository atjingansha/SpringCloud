package com.atwangjin.could.service;

import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author WangJin
 * @create 2022-04-26 21:20
 */

@Component
@FeignClient(value = "PAY-SERVICE")
public interface PayFeignService {


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
