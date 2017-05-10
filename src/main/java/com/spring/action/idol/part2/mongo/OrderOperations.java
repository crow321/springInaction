package com.spring.action.idol.part2.mongo;

import java.util.List;

/**
 * 中间接口：查询文档中type属性匹配给定值的Order对象
 * Created by zhangp on 2017/5/3.
 */
public interface OrderOperations {
    List<Order> findOrderByType(String t);
}