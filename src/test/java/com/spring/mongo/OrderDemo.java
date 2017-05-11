package com.spring.mongo;

import com.spring.action.idol.part2.mongo.entity.Item;
import com.spring.action.idol.part2.mongo.entity.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by zhangp on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/part2/config.xml")
public class OrderDemo {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        long orderCount = mongoTemplate.getCollection("order").count();

        Order order = new Order();
        order.setId("订单" + orderCount);

        Collection<Item> items = new LinkedHashSet<>();
        Item item = new Item();
        item.setQuantity(100);
        items.add(item);
        order.setItems(items);
        mongoTemplate.save(order);

        List<Order> chucksOrders = mongoTemplate.find(Query.query(Criteria.where("client").is("Chuck Wagon")), Order.class);
        System.out.println("chucksOrders:" + chucksOrders);
        Assert.assertEquals(3, mongoTemplate.getCollection("order").count());
        mongoTemplate.remove(order);
    }
}
