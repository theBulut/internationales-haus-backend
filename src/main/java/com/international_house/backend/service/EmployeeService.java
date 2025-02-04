package com.international_house.backend.service;

import com.international_house.backend.domain.Employee;
import com.international_house.backend.repos.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    
    public void deleteEmployeeById(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(UUID employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + employeeId + " not found"));

        if (updatedEmployee.getEmployeeName() != null) {
            existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
        }

        if (updatedEmployee.getPasswordHash() != null) {
            existingEmployee.setPasswordHash(updatedEmployee.getPasswordHash());
        }

        employeeRepository.save(existingEmployee);
    }
    
    
    
    
    
    
    
}
