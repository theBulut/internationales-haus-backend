package com.international_house.backend.service;

import com.international_house.backend.domain.Employee;
import com.international_house.backend.repos.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    // @Transactional
    public void updateEmployee(UUID id, Employee update) {
        Employee employee = employeeRepository.findById(id).get();

        if (employee != null) {
            employee.setIsAdmin(update.getIsAdmin());
            employee.setName(update.getName());
            employee.setPassword(update.getPassword());
            employee.setIsLoggedIn(update.getIsLoggedIn());

            employeeRepository.save(employee);
        } else
            throw new EntityNotFoundException("Employee not found with id: " + id);
    }

    public void deleteEmployeeById(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
