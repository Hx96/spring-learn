package com.hx.aop;

import com.hx.UpdateOrder;

public class UpdateOrderConvert implements Convert<UpdateOrder>{
    @Override
    public OperationLogDO convert(UpdateOrder param) {
        OperationLogDO operationLogDO = new OperationLogDO();
        operationLogDO.setOrderId(param.getOrderId());
        return operationLogDO;
    }
}
