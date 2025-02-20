package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.EmployeeEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.service.EmployeeService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.international_house.backend.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = EmployeeEndpoint.API_TAG)
@RequestMapping(path = EmployeeEndpoint.BASE_URI)
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> addNewEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addNewEmployee(employee);
        return ResponseEntity
                .ok(BaseResponseDto.builder().message("Employee added successfully!").data(newEmployee).build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return ResponseEntity
                .ok(BaseResponseDto.builder().message("Employees retrieved successfully!").data(employees).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> getEmployeeById(@PathVariable UUID id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity
                .ok(BaseResponseDto.builder().message("Employee retrieved successfully!").data(employee).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateEmployee(@PathVariable UUID id, @RequestBody Employee employee) {
        /* int updatedEmployee = */employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Employee updated successfully!")/*
                                                                                                     * .data(
                                                                                                     * updatedEmployee)
                                                                                                     */.build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Employee deleted successfully!").build());
    }
}
