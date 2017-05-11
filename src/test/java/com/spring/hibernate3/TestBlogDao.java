package com.spring.hibernate3;

import com.spring.action.idol.part2.hibernate.hibernate3.dao.ipml.BlogDaoIpml;
import com.spring.action.idol.part2.hibernate.hibernate3.entity.Blog;
import com.spring.action.idol.part2.hibernate.hibernate3.entity.BlogItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangp on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/part2/hibernate/hibernate3/spring-hibernate.xml")
public class TestBlogDao {
    @Autowired
    private BlogDaoIpml blogDao;

    @Test
    public void testBlogDaoIpml() throws Exception {
        Blog blog = blogDao.createBlog("MYBLOG1234");

        //
        blogDao.createBlogItemByBlogID((long) 2, "CreateBlogByID", "test");

        Blog blog1 = blogDao.getBlogAndAllItems((long) 2);

        List list1 = blogDao.listAllBlogNamesAndItemCounts(5);

        List list2 = blogDao.listBlogsAndRecentItems();
        System.out.println("**************list1****************");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        System.out.println("**************list2****************");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println("*************blog1*****************");
        System.out.println(blog1);
    }

    @Test
    public void testCreateBlogItem() {
        Blog blog = new Blog();
        blog.setName("MYBLOG2");
        blog.setId((long) 22);
        blog.setItems(new ArrayList<>());
        blogDao.createBlogItem(blog, "title2", "text2");
    }

}

