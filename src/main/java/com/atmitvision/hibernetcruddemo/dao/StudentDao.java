package com.atmitvision.hibernetcruddemo.dao;

import com.atmitvision.hibernetcruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateStudent(Student student);
    void delete(Integer id);
    int deleteAll();
}
