package com.atwnagjin.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author WangJin
 * @create 2022-04-28 18:37
 */
@Component
public class PaymentFallbcakService implements PaymentHstrixService{
    @Override
    public String payment_ok(Integer id) {
        return "fullBackPayment_OK😀";
    }

    @Override
    public String payment_sleep(Integer id) {
        return "fullBackPaymnet_sleep😢";
    }
}
