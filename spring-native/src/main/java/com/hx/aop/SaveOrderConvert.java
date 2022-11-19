package com.hx.aop;

import com.hx.SaveOrder;

public class SaveOrderConvert implements Convert<SaveOrder>{
    @Override
    public OperationLogDO convert(SaveOrder param) {
        OperationLogDO operationLogDO = new OperationLogDO();
        operationLogDO.setOrderId(param.getId());
        return operationLogDO;
    }
}
