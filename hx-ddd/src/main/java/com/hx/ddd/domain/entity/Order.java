package com.hx.ddd.domain.entity;

import com.hx.ddd.domain.repository.Aggregate;

public class Order implements Aggregate<OrderId> {
    @Override
    public OrderId getId() {
        return null;
    }
}
