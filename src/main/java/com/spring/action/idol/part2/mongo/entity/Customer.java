package com.spring.action.idol.part2.mongo.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by zhangp on 2017/5/3.
 */
@Entity
public class Customer {
    private String name;
    private String like;
    @Id
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
