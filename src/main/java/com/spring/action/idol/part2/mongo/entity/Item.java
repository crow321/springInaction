package com.spring.action.idol.part2.mongo.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by zhangp on 2017/5/3.
 */
@Entity
public class Item {
    @Id
    private String id;
    private String product;
    private double price;
    private int quantity;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "item:{ id =" + id + ", product =" + product + ", price =" + price + ", quantity =" + quantity + " }";
    }

}
