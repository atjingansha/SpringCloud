package com.atwangjin.could.Controller;

import com.atwangjin.could.Service.PaymentService;
import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangJin
 * @create 2022-04-18 21:06
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int add = paymentService.add(payment);
        log.info("插入结果:"+add);

        if (add>0){
            return new CommonResult(200,"插入成功,+serverPort:"+serverPort,add);
        }else {
            return new CommonResult(404,"插入失败",null);
        }
    }



    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果:"+paymentById);

        if (paymentById !=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,paymentById);
        }else {
            return new CommonResult(404,"没有对应结果"+id,null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String load(){
        return serverPort;
    }
}
