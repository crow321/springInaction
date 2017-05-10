package com.spring.action.idol.part2.mongo.ipml;

import com.spring.action.idol.part2.mongo.Order;
import com.spring.action.idol.part2.mongo.OrderOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangp on 2017/5/3.
 */
@Service("orderRepository")
public class OrderOperationIpml implements OrderOperations{
    Logger logger = LoggerFactory.getLogger(OrderOperationIpml.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Order> findOrderByType(String t) {
        //如果给定的类型是“NET”，则type值为“WEB”
        String type = t.equals("NET") ? "WEB" : t;
        //创建查询
        Criteria criteria = Criteria.where("type").is(type);
        Query query = Query.query(criteria);
        //执行查询
        return mongoTemplate.find(query, Order.class);
    }
}
