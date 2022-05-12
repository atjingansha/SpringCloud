package com.atwangjin.cloud.service;

import com.atwangjin.cloud.service.impl.FeignServiceImpl;
import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author WangJin
 * @create 2022-05-11 19:27
 */
@Component
@FeignClient(value = "nacos-payment-provider",fallback = FeignServiceImpl.class)
public interface FeignService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
