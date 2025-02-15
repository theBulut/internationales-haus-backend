package com.international_house.backend.service.impl;

import com.international_house.backend.entity.Employee;
import com.international_house.backend.exceptions.handled.EmployeeAlreadyExistException;
import com.international_house.backend.exceptions.handled.EmployeeNotFoundException;
import com.international_house.backend.repository.EmployeeRepository;
import com.international_house.backend.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public Employee addNewEmployee(Employee employee) {
        if (employeeRepository.findByName(employee.getName()).isPresent()) {
            throw new EmployeeAlreadyExistException();
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Optional<Employee> updateEmployee(UUID id, Employee update) {
        return employeeRepository.updateEmployeeById(id, update);
    }

    public void deleteEmployeeById(UUID employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(employeeId);
    }
}
