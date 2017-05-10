package com.spring.action.idol.part2.hibernate;

import com.spring.action.idol.part2.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 在这个类中，我们只是将Employee类的对象存储到数据库中。
 * 在这里，我们使用StandardServiceRegistryBuilder类和MetadataSources类从持久化类获取映射的信息。
 * Created by zhangp on 2017/5/8.
 */
public class ClientTest {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        /**2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂*/
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        /**** 上面是配置准备，下面开始我们的数据库操作 ******/
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(1001);
        e1.setFirstName("Yii");
        e1.setLastName("Bai");

        Employee e2 = new Employee();
        e2.setId(1002);
        e2.setFirstName("Min");
        e2.setLastName("Su");

        session.persist(e1);
        session.persist(e2);

        transaction.commit();

        session.close();
        factory.close();
        System.out.println("successfully saved.");
    }
}
