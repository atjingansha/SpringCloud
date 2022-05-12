package com.atwangjin.could.Controller;

import com.atwangjin.could.Service.PaymentService;
import com.atwangjin.could.pojo.CommonResult;
import com.atwangjin.could.pojo.Payment;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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


    @GetMapping("/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("************"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAY-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info("$$$$$$$$$"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }


    /**
     * 模拟长流程调用,演示Feign TimeOut
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }



    /**
     * 链路监控
     *
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall 这是zipkin所监控的payment8001链路";
    }

}
