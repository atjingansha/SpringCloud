package com.atwangjin.could.Service;

import com.atwangjin.could.pojo.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author WangJin
 * @create 2022-04-18 21:02
 */

public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
