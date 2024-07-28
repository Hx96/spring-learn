package com.hx.ddd.domain.entity;

import com.hx.ddd.domain.repository.Aggregate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order implements Aggregate<OrderId> {
    @Override
    public OrderId getId() {
        return null;
    }
}
