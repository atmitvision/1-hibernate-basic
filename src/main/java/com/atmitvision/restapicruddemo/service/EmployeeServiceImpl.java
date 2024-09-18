package com.atmitvision.restapicruddemo.service;

import com.atmitvision.restapicruddemo.dao.EmployeeRepository;
import com.atmitvision.restapicruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAdd() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else {
            throw new RuntimeException("Did Not find the Employee ID ="+ theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmplyee) {
        return employeeRepository.save(theEmplyee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
