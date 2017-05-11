package com.spring.action.idol.part2.hibernate.hibernate3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

/**
 * Created by zhangp on 2017/5/10.
 */
@Entity
public class BlogItem {
    @Id
    private Long id;
    private Calendar datetime;//日历
    private String text;
    private String title;
    private Blog blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }
}
