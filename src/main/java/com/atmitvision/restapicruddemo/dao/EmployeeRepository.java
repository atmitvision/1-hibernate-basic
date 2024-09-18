package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
