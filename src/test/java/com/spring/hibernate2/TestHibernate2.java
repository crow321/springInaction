package com.spring.hibernate2;

import com.spring.action.idol.part2.hibernate2.entity.Address;
import com.spring.action.idol.part2.hibernate2.entity.IDCard;
import com.spring.action.idol.part2.hibernate2.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试Hibernate2
 * Created by zhangp on 2017/5/9.
 */

public class TestHibernate2 {

    /**
     * 单向映射关系测试
     */
    //表1-1
    @Test
    public void testOne2One() {
        Configuration cfg = new Configuration().configure("part2/hibernate2/hibernate2.cfg.xml");
        cfg.addResource("part2/hibernate2/single/one2one.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setName("小明");
        person.setAddress(new Address("Hangzhou"));

        session.save(person);
        transaction.commit();

        factory.close();
        session.close();
    }

    //1-2
    @Test
    public void testManyToOne() {
        Configuration cfg = new Configuration().configure("part2/hibernate2/hibernate2.cfg.xml");
        cfg.addResource("part2/hibernate2/single/many2one.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Address address = new Address("Hangzhou");

        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setName("小明");
            //关联
            person.setAddress(address);

            session.save(person);
        }

        transaction.commit();

        factory.close();
        session.close();
    }

    //1-3
    @Test
    public void testOneToMany() {
        Configuration cfg = new Configuration().configure("part2/hibernate2/hibernate2.cfg.xml");
        cfg.addResource("part2/hibernate2/single/one2many.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Set<Address> set = new HashSet<Address>();
        set.add(new Address("position1"));
        set.add(new Address("position2"));
        set.add(new Address("position3"));

        Person person = new Person();
        person.setName("xiaoming");
        person.setAddresses(set);

        session.save(person);
        transaction.commit();

        factory.close();
        session.close();
    }

    //1-4
    @Test
    public void testManyToMany() {
        Configuration cfg = new Configuration().configure("part2/hibernate2/hibernate2.cfg.xml");
        cfg.addResource("part2/hibernate2/single/many2many.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Set<Address> set = new HashSet<Address>();
        set.add(new Address("manyposition1"));
        set.add(new Address("manyposition2"));
        set.add(new Address("manyposition3"));

        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setName("ManyToMany");
            person.setAddresses(set);

            session.save(person);
        }

        transaction.commit();

        factory.close();
        session.close();
    }

    /**
     * 双向映射关系测试
     */
    //2-1
    @Test
    public void testDoubleOne2One() {
        Configuration cfg = new Configuration().configure("part2/hibernate2/hibernate2.cfg.xml");
        cfg.addResource("part2/hibernate2/double/one2one.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setName("小明");
        person.setAddress(new Address("Shanghai"));
        session.save(person);

        transaction.commit();

        factory.close();
        session.close();
    }

    /**
     * 先写person，在写addresss
     */
    //2-2
    @Test
    public void testDoubleOneToMany() {
        Configuration cfg = new Configuration();
        cfg.configure("/part2/hibernate2/hibernate2.cfg.xml")
                .addResource("/part2/hibernate2/double/one2many.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setIdCard(new IDCard("DoubleOneToMany"));
        person.setName("小刚");
        session.save(person);

        Address add1 = new Address("DoubleOneToMany position1");
        add1.setPerson(person);
        Address add2 = new Address("DoubleOneToMany position2");
        add2.setPerson(person);

        session.save(add1);
        session.save(add2);

        transaction.commit();

        factory.close();
        session.close();
    }

    //2-3
    @Test
    public void testDoubleManyToMany() {
        Configuration cfg = new Configuration();
        cfg.configure("/part2/hibernate2/hibernate2.cfg.xml")
                .addResource("/part2/hibernate2/double/many2many.hbm.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Person p1 = new Person();
        p1.setName("qqq");

        Person p2 = new Person();
        p2.setName("www");

        Set<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);

        Address add1 = new Address("New York");
        add1.setPersons(personSet);

        Address add2 = new Address("Paris");
        add2.setPersons(personSet);

        session.save(add1);
        session.save(add2);

        transaction.commit();

        session.close();
        factory.close();
    }
}
