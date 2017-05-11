package com.spring.mongo;

import com.spring.action.idol.part2.mongo.entity.Customer;
import com.spring.action.idol.part2.mongo.entity.Item;
import com.spring.action.idol.part2.mongo.entity.Order;
import com.spring.action.idol.part2.mongo.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by zhangp on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/part2/config.xml")
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertByOrder(){
        Customer customer = new Customer();
        customer.setId("顾客1:");
        customer.setLike("apple");
        customer.setName("Tom");

        Item item = new Item();
        item.setId("水果1");
        item.setProduct("banana");
        item.setPrice(20);
        item.setQuantity(5);

        Collection<Item> items = new LinkedHashSet<Item>();
        items.add(item);
        Order order = new Order();
        order.setId("订单3");
        order.setCustomer(customer);
        order.setItems(items);

        orderDao.insertByOrder(order);
    }

}
