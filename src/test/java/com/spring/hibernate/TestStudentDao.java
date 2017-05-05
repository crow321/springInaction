package com.spring.hibernate;

import com.spring.action.idol.part2.hibernate.dao.StudentDao;
import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangp on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/part2/hibernate/hibernate.xml")
public class TestStudentDao {
    @Autowired
    StudentDao studentDao;

    @Test
    public void testGetStudentById(){

    }

    @Test
    public void testAddStudent(){
        StudentsEntity entity = new StudentsEntity();
//        entity.setId("101");
        entity.setName("实习生");
        studentDao.addStudent(entity);
    }
}
