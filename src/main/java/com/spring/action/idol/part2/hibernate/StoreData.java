package com.spring.action.idol.part2.hibernate;

import com.spring.action.idol.part2.hibernate.entity.ContractEmployee;
import com.spring.action.idol.part2.hibernate.entity.Employee;
import com.spring.action.idol.part2.hibernate.entity.RegularEmployee;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by zhangp on 2017/5/8.
 */
public class StoreData {
    public static void main(String[] args) {
        /*Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();*/

        Session session = HibernateSessionFactory.getSession();

        Transaction transaction = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setFirstName("crow");

        RegularEmployee e2 = new RegularEmployee();
        e2.setFirstName("Max su");
        e2.setBonus(5);
        e2.setSalary(50000);

        ContractEmployee e3 = new ContractEmployee();
        e3.setFirstName("Hippo su");
        e3.setContractDuration("10 hours");
        e3.setPayPerHour(1000);

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        transaction.commit();

        session.close();
        HibernateSessionFactory.getSessionFactory().close();
    }
}
