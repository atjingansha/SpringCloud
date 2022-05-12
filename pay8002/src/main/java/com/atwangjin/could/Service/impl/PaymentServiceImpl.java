package com.atwangjin.could.Service.impl;

import com.atwangjin.could.Service.PaymentService;
import com.atwangjin.could.mapper.PaymentMapper;
import com.atwangjin.could.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangJin
 * @create 2022-04-18 21:03
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
