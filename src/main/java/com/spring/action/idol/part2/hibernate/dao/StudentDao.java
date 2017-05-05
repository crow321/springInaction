package com.spring.action.idol.part2.hibernate.dao;

import com.spring.action.idol.part2.hibernate.entity.StudentsEntity;

/**
 * Created by zhangp on 2017/5/5.
 */
public interface StudentDao {

    StudentsEntity getStudentById(String id);

    boolean addStudent(StudentsEntity student);

    boolean updateStudent(StudentsEntity student);

    boolean deleteStudentById(String id);

}
