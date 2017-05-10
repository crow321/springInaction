package com.spring.action.idol.part2.hibernate2.entity;

import java.util.Set;

/**
 * Created by zhangp on 2017/5/9.
 */
public class Address {
    private int id;
    private String address;
    private Person person;
    private Set<Person> persons;

    public Address() {

    }

    public Address(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
