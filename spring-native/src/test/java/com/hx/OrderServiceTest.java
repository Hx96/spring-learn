package com.hx;

import org.junit.Assert;
import org.junit.Test;

public class OrderServiceTest {
    OrderService orderService = new OrderService();

    @Test
    public void testSaveOrder() throws Exception {
        Boolean result = orderService.saveOrder(new SaveOrder());
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testUpdateOrder() throws Exception {
        Boolean result = orderService.updateOrder(new UpdateOrder());
        Assert.assertEquals(Boolean.TRUE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme