package com.spring.action.idol.part2.mongo.dao.ipml;

import com.mongodb.WriteResult;
import com.spring.action.idol.part2.mongo.entity.Customer;
import com.spring.action.idol.part2.mongo.entity.Order;
import com.spring.action.idol.part2.mongo.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangp on 2017/5/3.
 */
@Service("orderDao")
public class OrderDaoIpml implements OrderDao {
    Logger logger = LoggerFactory.getLogger(OrderDaoIpml.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean insertByOrder(Order order) {
        try {
            mongoTemplate.insert(order);
        } catch (Exception e) {
            e.getLocalizedMessage();
            return false;
        }
        return true;
    }

    @Override
    public List<Order> findByCustomer(Customer c) {
        Criteria criteria = Criteria.where("client").is(c);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Order.class);
    }

    @Override
    public List<Order> findByCustomerLike(String customerLike) {
        Criteria criteria = Criteria.where("client").is(customerLike);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Order.class);
    }

    @Override
    public List<Order> findByCustomerAndType(Customer c, String t) {
        Criteria criteria = Criteria.where("client").is(c).and("type").is(t);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Order.class);
    }

    @Override
    public List<Order> findByCustomerLikeAndType(String customerLike, String t) {
        Criteria criteria = Criteria.where("client").is(customerLike).and("type").is(t);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Order.class);
    }

    @Override
    public boolean updateByOrderID(Order order) {
        Criteria criteria = Criteria.where("_id").is(order.getId());
        Query query = Query.query(criteria);

        Update update = new Update();
        update.set("client", order.getCustomer());
        update.set("type", order.getType());
        update.set("items", order.getItems());
        WriteResult result = mongoTemplate.updateMulti(query, update, Order.class);

        if (result.getN() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean deleteByOrderID(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Order.class);
        return true;
    }

    @Override
    public int countByCustomer(Customer c) {
        Criteria criteria = Criteria.where("client");
        Query query = Query.query(criteria);
        return (int) mongoTemplate.count(query, Order.class);
    }

    @Override
    public List<Order> findOrderByType(String t) {
        //如果给定的类型是“NET”，则type值为“WEB”
        String type = t.equals("NET") ? "WEB" : t;
        Criteria criteria = Criteria.where("type").is(type);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Order.class);
    }
}
