package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

public interface OrderMapper {

    /**
     *  插入订单数据
     * @param order
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     *  插入订单项数据
     * @param orderItem
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);



}
