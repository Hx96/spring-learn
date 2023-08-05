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

    /**
     * // 自定义Count接口，在这里OrderQuery是一个自定义的DTO
     *
     * @param query 查询
     * @return {@link Long}
     */
    Long count(OrderQuery query);

    /**
     * 查询
     * // 自定义分页查询接口
     * @param query 查询
     * @return {@link Page}<{@link Order}>
     */
    Page<Order> query(OrderQuery query);

    /**
     * 在商店
     * // 自定义有多个条件的查询接口
     *
     * @param id      id
     * @param storeId 存储id
     * @return {@link Order}
     */
    Order findInStore(OrderId id, StoreId storeId);
}
