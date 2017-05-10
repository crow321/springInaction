package com.spring.action.idol.part2.hibernate.entity;

/**
 * Created by zhangp on 2017/5/8.
 */
public class RegularEmployee extends Employee {
    private float salary;
    private int bonus;

    public RegularEmployee() {
        super();
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
