package com.hx.springcloud.dao;

import com.hx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 35762
 */
@Mapper
public interface PaymentDao {
  /**
   * 新增
   * @param payment id 串行化
   * @return 是否成功
   */
  int create(Payment payment);

  /**
   * 根据 ID获取
   * @param id id 串行化
   * @return 实体类
   */
  Payment getPaymentById(@Param("id") Long id);
}
