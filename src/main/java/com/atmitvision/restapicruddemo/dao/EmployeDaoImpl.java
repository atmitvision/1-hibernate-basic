package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> typedQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employeeList=typedQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee= entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmplyee) {
        Employee employee=entityManager.merge(theEmplyee);
        return employee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee=entityManager.find(Employee.class,theId);
        entityManager.remove(employee);
    }
}
