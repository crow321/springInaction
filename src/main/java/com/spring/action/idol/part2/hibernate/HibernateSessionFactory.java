package com.spring.action.idol.part2.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangp on 2017/5/5.
 */
public class HibernateSessionFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(HibernateSessionFactory.class);
    private final static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    static {
        LOGGER.info("HibernateSessionFactory.static");

        try {
            /*Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();*/
            registry = new StandardServiceRegistryBuilder()
                    .configure("part2/hibernate/hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
