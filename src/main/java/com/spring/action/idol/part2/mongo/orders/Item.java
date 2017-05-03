package com.spring.action.idol.part2.mongo.orders;

/**
 * Created by zhangp on 2017/5/3.
 */
public class Item {
    private Long id;
    //private Order order;
    private String product;
    private double price;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Order getOrder() {
        return order;
    }*/

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
