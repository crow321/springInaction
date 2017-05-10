package com.spring.action.idol.part2.hibernate.Collection;

import com.spring.action.idol.part2.hibernate.Collection.ListQuestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangp on 2017/5/8.
 */
public class ClientCollection {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("/part2/hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();

        List<String> list1 = new ArrayList<String>();
        list1.add("java is a programing language");
        list1.add("platform");

        List<String> list2 = new ArrayList<String>();
        list2.add("servlet is an Interface");
        list2.add("servlet is an API");

        ListQuestion q1 = new ListQuestion();
        q1.setName("what is java?");
        q1.setAnswers(list1);

        ListQuestion q2 = new ListQuestion();
        q2.setName("what is servlet?");
        q2.setAnswers(list2);

        session.persist(q1);
        session.persist(q2);

        ts.commit();

        //query
        Query<ListQuestion> query = session.createQuery("from ListQuestion");
        List<ListQuestion> list = query.list();

        Iterator<ListQuestion> iterator = list.iterator();
        while (iterator.hasNext()) {
            ListQuestion q = iterator.next();
            System.out.println("Question name:" + q.getName());

            List<String> listAnswers = q.getAnswers();
            Iterator iterator1 = listAnswers.iterator();
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }
        }

        session.close();
        System.out.println("success");
    }


}
