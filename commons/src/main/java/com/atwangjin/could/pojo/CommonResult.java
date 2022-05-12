package com.atwangjin.could.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangJin
 * @create 2022-04-18 20:35
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T>{
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
