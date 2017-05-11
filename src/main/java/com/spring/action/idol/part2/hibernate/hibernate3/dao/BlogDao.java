package com.spring.action.idol.part2.hibernate.hibernate3.dao;

import com.spring.action.idol.part2.hibernate.hibernate3.entity.Blog;
import com.spring.action.idol.part2.hibernate.hibernate3.entity.BlogItem;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by zhangp on 2017/5/10.
 */
public interface BlogDao {
    public Blog createBlog(String name) throws HibernateException;

    public BlogItem createBlogItem(Blog blog, String title, String text) throws HibernateException;

    public BlogItem createBlogItemByBlogID(Long blogid, String title, String text) throws HibernateException;

    public void updateBlogItem(BlogItem blogItem, String text) throws HibernateException;

    public void updateBlogItemByItemID(Long itemid, String text) throws HibernateException;

    public List listAllBlogNamesAndItemCounts(int max) throws HibernateException;

    public Blog getBlogAndAllItems(Long blogid) throws HibernateException;

    public List listBlogsAndRecentItems() throws HibernateException;
}
