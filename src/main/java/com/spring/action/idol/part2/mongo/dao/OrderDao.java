package com.spring.action.idol.part2.mongo.dao;

import com.spring.action.idol.part2.mongo.entity.Customer;
import com.spring.action.idol.part2.mongo.entity.Order;

import java.util.List;

/**
 * 实现MongoRepository接口和自定义的中间接口OrderOperations, 并自定义方法
 * Created by zhangp on 2017/5/3.
 */
public interface OrderDao {
    boolean insertByOrder(Order order);

    List<Order> findByCustomer(Customer c);
    List<Order> findByCustomerLike(String customerLike);
    List<Order> findByCustomerAndType(Customer c, String t);
    List<Order> findByCustomerLikeAndType(String customerLike, String t);

    boolean updateByOrderID(Order order);

    boolean deleteByOrderID(String id);

    int countByCustomer(Customer c);

    List<Order> findOrderByType(String t);
}
