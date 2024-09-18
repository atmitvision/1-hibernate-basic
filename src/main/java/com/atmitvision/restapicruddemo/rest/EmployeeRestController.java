package com.atmitvision.restapicruddemo.rest;

import com.atmitvision.restapicruddemo.entity.Employee;
import com.atmitvision.restapicruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAdd();
    }
    @GetMapping("/employees/{employeeId}")
    public  Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found Id is= "+ employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public  Employee save(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee employee=employeeService.save(theEmployee);
        return employee;
    }

    @PutMapping("/employees")
    public  Employee update(@RequestBody Employee theEmployee){
        Employee employee=employeeService.save(theEmployee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee is not found-"+theEmployee);
        }
        employeeService.deleteById(employeeId);

        return "Deleted Employee Id "+employeeId;
    }

}
