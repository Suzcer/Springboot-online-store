package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {


    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        Order order=new Order();
        order.setUid(10);
        order.setRecvName("明明");
        order.setRecvPhone("12345");
        orderMapper.insertOrder(order);

    }


    @Test
    public void insertOrderItem(){
        OrderItem orderItem=new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000003);
        orderItem.setTitle("广博线圈记事本日记本");

        orderMapper.insertOrderItem(orderItem);

    }

}
