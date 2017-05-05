package com.spring.action.idol.part2.hibernate.dao.ipml;

import com.spring.action.idol.part2.hibernate.dao.StudentDao;
import com.spring.action.idol.part2.hibernate.HibernateSessionFactory;
import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by zhangp on 2017/5/5.
 */
@Service("studentDao")
public class StudentDaoIpml implements StudentDao {

    @Override
    public StudentsEntity getStudentById(String id) {
        StudentsEntity student = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<StudentsEntity> query = session.createQuery("from StudentsEntity where id=" + id, StudentsEntity.class);
            student = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.getLocalizedMessage();
            return null;
        }finally {
            session.close();
        }
        return student;
    }

    @Override
    public boolean addStudent(StudentsEntity student) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.getLocalizedMessage();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean updateStudent(StudentsEntity student) {
        return false;
    }

    @Override
    public boolean deleteStudentById(String id) {
        return false;
    }
}
