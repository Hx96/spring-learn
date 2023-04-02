package com.hx.ddd.infrastructure.impl;

import com.hx.ddd.domain.entity.Order;
import com.hx.ddd.domain.entity.OrderId;
import com.hx.ddd.domain.repository.OrderQuery;
import com.hx.ddd.domain.repository.OrderRepository;
import com.hx.ddd.domain.repository.Page;
import com.hx.ddd.domain.repository.StoreId;

/**
 * 顺序存储库impl
 *
 * @author kyle
 * @date 2023/03/17
 */
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void attach(Order aggregate) {

    }

    @Override
    public void detach(Order aggregate) {

    }

    @Override
    public Order find(OrderId orderId) {
        return null;
    }

    @Override
    public void remove(Order aggregate) {

    }

    @Override
    public void save(Order aggregate) {

    }

    @Override
    public Long count(OrderQuery query) {
        return null;
    }

    @Override
    public Page<Order> query(OrderQuery query) {
        return null;
    }

    @Override
    public Order findInStore(OrderId id, StoreId storeId) {
        return null;
    }
}
