package com.spring.action.idol.part2.hibernate.Collection;

import java.util.List;

/**
 * Created by zhangp on 2017/5/8.
 */
public class ListQuestion {
    private int id;
    private String name;
    private List<String> answers;

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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
