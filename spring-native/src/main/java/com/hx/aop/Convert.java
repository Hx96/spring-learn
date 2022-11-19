package com.hx.aop;

/**
 * @author kyle
 */
public interface Convert<T> {

    /**
     * 根据传入方法来确定入参的订单ID
     * @param param
     * @return
     */
    OperationLogDO convert(T param);
}
