package com.spring.action.idol.part2.hibernate.hibernate3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by zhangp on 2017/5/10.
 */
@Entity
public class Blog {
    @Id
    private Long id;
    private String name;
    private List items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    /*@Override
    public String toString() {
        String blog = "blog{id:" + id + ", name:" + name + ", items:" + items + " }";
        return blog;
    }*/
}
