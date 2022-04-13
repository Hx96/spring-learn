package com.hx.springcloud.service;

import com.hx.springcloud.dao.PaymentDao;
import com.hx.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * service 方法
 * @author 35762
 */
@Service
public class PaymentServiceImpl implements PaymentService{
  @Resource
  private PaymentDao paymentDao;

  @Override
  public int create(Payment payment){
    return paymentDao.create(payment);
  }


  @Override
  public Payment getPaymentById(Long id){
    return paymentDao.getPaymentById(id);
  }

}
