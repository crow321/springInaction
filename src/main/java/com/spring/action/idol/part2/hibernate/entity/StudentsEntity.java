package com.spring.action.idol.part2.hibernate.entity;

import javax.persistence.Entity;

/**
 * Created by zhangp on 2017/5/5.
 */
@Entity
public class StudentsEntity {
    private String name;
    private int age;
    private String sex;
    private String addres;
    private int telephone;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (age != that.age) return false;
        if (id != that.id) return false;
        if (telephone != that.telephone) return false;
        if (addres != null ? !addres.equals(that.addres) : that.addres != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (addres != null ? addres.hashCode() : 0);
        result = 31 * result + telephone;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "student[name:" + name + ", id:" + id + ", age:" + age
                + ", sex:" + sex + ", address:" + addres + ", tel:" + telephone + "]";
    }
}
