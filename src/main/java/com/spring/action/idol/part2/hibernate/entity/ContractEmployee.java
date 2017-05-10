package com.spring.action.idol.part2.hibernate.entity;

/**
 * Created by zhangp on 2017/5/8.
 */
public class ContractEmployee extends Employee {
    private float payPerHour;
    //合约持续时间
    private String contractDuration;

    public ContractEmployee() {
        super();
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }
}
