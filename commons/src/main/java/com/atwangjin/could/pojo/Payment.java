package com.atwangjin.could.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangJin
 * @create 2022-04-18 20:31
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Serializable {
  private   Long id;
  private   String serial;
}
