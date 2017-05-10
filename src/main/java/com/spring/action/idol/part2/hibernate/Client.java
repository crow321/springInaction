package com.spring.action.idol.part2.hibernate;

import com.spring.action.idol.part2.hibernate.entity.NewsEntity;
import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangp on 2017/5/5.
 */
public class Client {
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        LOGGER.info("hibernate...");
        Session session = null;
        SessionFactory factory = null;
        try {
            Configuration conf = new Configuration();
            conf.configure();
//        conf.addClass(StudentsEntity.class).addResource("part2/hibernate/StudentsEntity.hbm.xml");
//        conf.addClass(NewsEntity.class).addResource("part2/hibernate/NewsEntity.hbm.xml");

            factory = conf.buildSessionFactory();
            session = factory.openSession();

            //开启事物
            Transaction tx = session.beginTransaction();

            StudentsEntity entity = new StudentsEntity();
            //entity.setId(102);
            entity.setName("test");
            entity.setAge(18);
            entity.setTelephone(123);
            entity.setAddres("address");
            entity.setSex("男");

            session.save(entity);

            NewsEntity news = new NewsEntity();
            news.setTitle("news");
            news.setContent("beyondBoy");
            news.setFullContent("test");
//        news.setId(101);

            session.save(news);
            System.out.println("连接数据库：" + session.isConnected());
            System.out.println(session.getStatistics());

            tx.commit();
        } catch (Exception e) {
            //
        } finally {
            factory.close();
            session.close();
        }
    }
}
