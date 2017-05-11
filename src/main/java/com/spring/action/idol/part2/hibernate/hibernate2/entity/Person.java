package com.spring.action.idol.part2.hibernate.hibernate2.entity;

import java.util.Set;

/**
 * Created by zhangp on 2017/5/9.
 */
public class Person {
    private int id;
    private String name;
    private IDCard idCard;
    private Address address;
    private Set<Address> addresses;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
