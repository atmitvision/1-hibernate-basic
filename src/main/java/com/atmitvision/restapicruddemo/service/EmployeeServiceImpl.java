package com.atmitvision.restapicruddemo.service;

import com.atmitvision.restapicruddemo.dao.EmployeeDao;
import com.atmitvision.restapicruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }

    @Override
    public List<Employee> findAdd() {
        return employeeDao.getAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmplyee) {
        return employeeDao.save(theEmplyee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
