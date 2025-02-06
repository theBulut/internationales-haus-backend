package com.international_house.backend.controller;

import com.international_house.backend.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.international_house.backend.domain.Employee;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path="/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable UUID id){
        return employeeService.getEmployeeById(id).get();
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable UUID id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id){
        employeeService.deleteEmployeeById(id);
    }
}
