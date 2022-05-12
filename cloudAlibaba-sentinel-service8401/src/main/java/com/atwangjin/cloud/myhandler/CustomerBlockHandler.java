package com.atwangjin.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atwangjin.could.pojo.CommonResult;

/**
 * @author WangJin
 * @create 2022-05-10 20:38
 */
public class CustomerBlockHandler {


    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }


    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }

}
