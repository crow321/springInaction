package com.spring.action.idol.part2.hibernate;

import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangp on 2017/5/5.
 */
public class HibernateSessionFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(HibernateSessionFactory.class);
    private final static SessionFactory sessionFactory;
    private final static ServiceRegistry registry;

    static {
        LOGGER.info("static");
        try {
            Configuration configuration = new Configuration().configure();
            //configuration.addClass(StudentsEntity.class);
            registry = new StandardServiceRegistryBuilder().build();
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }

    }
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
