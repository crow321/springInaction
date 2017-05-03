package com.spring.action.idol.part2.mongo.orders;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Order类添加了@Document注解，这样它就能够借助MongoTemplate或自动生成的Repository进行持久化。
 * Created by zhangp on 2017/5/3.
 */
@Document
public class Order {
    //用来指定它作为文档的ID
    @Id
    private String id;
    //当文档持久化的时候customer属性将会映射为名为client的域
    @Field("client")
    private Customer customer;

    private String type;
    private Collection<Item> items = new LinkedHashSet<Item>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection getItems() {
        return items;
    }

    public void setItems(Collection items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{ id =" + id + ", customer =" + customer + ", type =" + type + ", Items =" + items + "}";
    }
}
