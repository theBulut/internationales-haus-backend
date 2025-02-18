package com.international_house.backend.service;

import com.international_house.backend.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    Employee addNewEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(UUID id);

    Optional<Employee> updateEmployee(UUID id, Employee update);

    void deleteEmployeeById(UUID employeeId);
}
