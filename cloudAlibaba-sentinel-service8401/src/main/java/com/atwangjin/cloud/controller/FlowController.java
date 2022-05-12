package com.atwangjin.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author WangJin
 * @create 2022-05-09 21:39
 */
@RestController
@Slf4j
public class FlowController {

    @GetMapping("/testA")
    public String testA() {
        // 测试阈值类型：线程数
//       try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }


    /**
     * 测试sentinel平均响应时间RT
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        //try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        //log.info("testD 测试RT");
        log.info("testD 测试异常比例");

        int num= 1/0;
        return "------testD";
    }


    /**
     * 测试sentinel异常数
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");

        int num= 1/0;
        return "------testE";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey") //名称随便起,注意唯一,建议与GetMapping名称一致
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        int num= 1/0;
        return "testHotKey";
    }


    /**
     * testHotKey出错后执行此方法
     * @param p1
     * @param p2
     * @param blockException
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException blockException){

        return "deal_testHotKey";
    }
}
