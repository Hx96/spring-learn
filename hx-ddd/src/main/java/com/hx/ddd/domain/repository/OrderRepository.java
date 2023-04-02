package com.hx.ddd.domain.repository;

import com.hx.ddd.domain.entity.Order;
import com.hx.ddd.domain.entity.OrderId;

/**
 * 顺序存储库
 *
 * @author kyle
 * @date 2023/03/17
 */
public interface OrderRepository extends Repository<Order, OrderId> {

    // 自定义Count接口，在这里OrderQuery是一个自定义的DTO
    Long count(OrderQuery query);

    // 自定义分页查询接口
    Page<Order> query(OrderQuery query);

    // 自定义有多个条件的查询接口
    Order findInStore(OrderId id, StoreId storeId);
}
