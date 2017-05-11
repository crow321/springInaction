package com.spring.action.idol.part2.hibernate.hibernate3.dao.ipml;

import com.spring.action.idol.part2.hibernate.hibernate3.dao.BlogDao;
import com.spring.action.idol.part2.hibernate.hibernate3.entity.Blog;
import com.spring.action.idol.part2.hibernate.hibernate3.entity.BlogItem;
import com.spring.action.idol.part2.mongo.entity.Item;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;


import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhangp on 2017/5/10.
 */
@Repository("blogDao")
public class BlogDaoIpml implements BlogDao {
    /*@Autowired
    private HibernateTransactionManager transactionManager;*/
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Blog createBlog(String name) throws HibernateException {
        Blog blog = new Blog();
        blog.setName(name);
        blog.setItems(new ArrayList<BlogItem>());

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(blog);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        return blog;
    }

    @Override
    public BlogItem createBlogItem(Blog blog, String title, String text) throws HibernateException {
        BlogItem blogItem = new BlogItem();
        blogItem.setBlog(blog);
        blogItem.setTitle(title);
        blogItem.setText(text);
        blogItem.setDatetime(Calendar.getInstance());
        blog.getItems().add(blogItem);

        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(blog);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        return blogItem;
    }

    @Override
    public BlogItem createBlogItemByBlogID(Long blogid, String title, String text) throws HibernateException {

        BlogItem item = new BlogItem();
        item.setDatetime(Calendar.getInstance());
        item.setText(text);
        item.setTitle(title);

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Blog blog = session.load(Blog.class, blogid);
            item.setBlog(blog);
            blog.getItems().add(item);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

        return item;
    }

    @Override
    public void updateBlogItem(BlogItem blogItem, String text) throws HibernateException {
        blogItem.setText(text);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.update(blogItem);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void updateBlogItemByItemID(Long itemid, String text) throws HibernateException {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            BlogItem item = session.load(BlogItem.class, itemid);
            session.save(item);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Blog> listAllBlogNamesAndItemCounts(int max) throws HibernateException {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List result = null;
        String hql = "select blog.id, blog.name from Blog as blog";
        try {
            transaction = session.beginTransaction();
           /* Query query = session.createQuery(
                            "select blog.id, blog.name, count(blogItem)" +
                            "from Blog as blog" +
                            "left outer join blog.items as blogItem" +
                            "group by blog.name, blog.id" +
                            "order by max(blogItem.datetime)"
            );*/
            Query query = session.createQuery(hql);
            query.setMaxResults(max);
            result = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public Blog getBlogAndAllItems(Long blogid) throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Blog blog = null;
        String hql = "select blog from Blog as blog left join blog.items where blog.id = :blogid";
        try {
            transaction = session.beginTransaction();
            /*Query hql = session.createQuery(
                    "from Blog as blog" +
                            "left outer join fetch blog.items" +
                            "where blog.id = :blogid"
            );*/
            Query query = session.createQuery(hql);
            query.setParameter("blogid", blogid);
            blog = (Blog) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

        return blog;
    }

    @Override
    public List listBlogsAndRecentItems() throws HibernateException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List result = null;
        String hql = "from Blog as blog inner join blog.items as item where item.datetime > :minDate";
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            Calendar calendar = Calendar.getInstance();
            calendar.roll(Calendar.MONTH, false);
            query.setParameter("minDate", calendar);
            result = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
