package com.spring.hibernate;

import com.spring.action.idol.part2.hibernate.dao.StudentDao;
import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;
import org.junit.Assert;
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
    public void testGetStudentById() {
        StudentsEntity student = studentDao.getStudentById("1");
        Assert.assertEquals(101, student.getTelephone());
        //System.out.println(student);
    }

    @Test
    public void testAddStudent(){
        StudentsEntity entity = new StudentsEntity();
        entity.setName("AddStudent");
        entity.setAge(18);
        entity.setTelephone(123);
        entity.setAddres("address");
        entity.setSex("男");

        studentDao.addStudent(entity);
    }
}
