package com.hx;

import com.hx.aop.RecordOperate;
import com.hx.aop.SaveOrderConvert;
import com.hx.aop.UpdateOrderConvert;
import com.mzt.logapi.starter.annotation.LogRecord;
import org.springframework.stereotype.Service;

/**
 * @author kyle
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class, argsOrder = 0)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save Order: " + saveOrder.getId());
        return true;
    }
    @RecordOperate(desc = "修改订单", convert = UpdateOrderConvert.class, argsOrder = 0)
    @LogRecord(
            success = "{{#updateOrder.orderId}}下了一个订单,购买商品「{{#updateOrder.orderId}}」,测试变量「{{#updateOrder.orderId}}」,下单结果:{{#_ret}}",
            type = "修改订单", bizNo = "{{#updateOrder.orderId}}")
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("update order: " + updateOrder.getOrderId());
        return true;
    }
}
