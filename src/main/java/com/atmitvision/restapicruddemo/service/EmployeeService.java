package com.atmitvision.restapicruddemo.service;

import com.atmitvision.restapicruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAdd();
    Employee findById(int theId);
    Employee save(Employee theEmplyee);
    void deleteById(int theId);
}
