package com.atwangjin.cloud.service.impl;

import com.atwangjin.cloud.service.FeignService;
import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 *
 * 如果FeignService发生错误的话会调用此方法作为兜底方法
 * @author WangJin
 * @create 2022-05-11 19:34
 */

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(44444,"服务降级返回,-------->FeignServiceImpl",new Payment(id,"error"));
    }
}
