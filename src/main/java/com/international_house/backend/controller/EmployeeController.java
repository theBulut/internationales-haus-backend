package com.international_house.backend.controller;

import com.international_house.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.international_house.backend.domain.Employee;
import java.util.List;


@RestController
@RequestMapping(path="/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployeeById(employee.getId());
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee.getId(), employee);
    }
}
