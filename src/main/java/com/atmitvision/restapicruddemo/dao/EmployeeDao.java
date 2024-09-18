package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll();
    Employee findById(int theId);
    Employee save(Employee theEmplyee);
    void deleteById(int theId);
}
