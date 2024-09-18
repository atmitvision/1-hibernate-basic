package com.atmitvision.hibernetcruddemo.dao;

import com.atmitvision.hibernetcruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query=entityManager.createQuery("FROM Student order by firstName asc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query=entityManager.createQuery("FROM Student  where lastName= :theLastName",Student.class);
        query.setParameter("theLastName",lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
         entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int returnResult=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return returnResult;
    }
}
