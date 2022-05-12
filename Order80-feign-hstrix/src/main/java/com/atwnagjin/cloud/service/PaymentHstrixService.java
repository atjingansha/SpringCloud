package com.atwnagjin.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author WangJin
 * @create 2022-04-27 21:38
 */
@Component
@FeignClient(value = "PAY-SERVICE-HSTRIX",fallback =PaymentFallbcakService.class)
public interface PaymentHstrixService {

    @GetMapping("/payment/hystirx/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystirx/error/{id}")
    public String payment_sleep(@PathVariable("id") Integer id);
}
