package com.spring.action.idol.part2.hibernate.hibernate2.entity;

/**
 * Created by zhangp on 2017/5/9.
 */
public class IDCard {
    private int id;
    private String cardNo;
    private Person person;

    public IDCard() {

    }

    public IDCard(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
