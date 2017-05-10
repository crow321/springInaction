package com.spring.mongo;

import com.spring.action.idol.part2.mongo.Customer;
import com.spring.action.idol.part2.mongo.Item;
import com.spring.action.idol.part2.mongo.Order;
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
public class OrderDaoDemo {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertByOrder(){
        Customer customer = new Customer();
        customer.setLike("apple");
        customer.setName("Tom");

        Item item = new Item();
        item.setId((long) 1);
        item.setProduct("banana");

        Collection<Item> items = new LinkedHashSet<Item>();
        items.add(item);
        Order order = new Order();
        order.setId("103");
        order.setCustomer(customer);
        order.setItems(items);

        orderDao.insertByOrder(order);

    }

}
