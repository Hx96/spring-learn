package com.hx.springcloud.service;

import com.hx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * service 层
 * @author 35762
 */
public interface PaymentService {
  /**
   * 增加
   * @param payment id
   * @return 是否成功
   */
  public int create(Payment payment);

  /**
   * get
   * @param id id
   * @return shitilei
   */
  public Payment getPaymentById(@Param("id") Long id);
}
