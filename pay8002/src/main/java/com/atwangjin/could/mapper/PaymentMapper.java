package com.atwangjin.could.mapper;

import com.atwangjin.could.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author WangJin
 * @create 2022-04-18 20:40
 */

@Mapper
public interface PaymentMapper {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
