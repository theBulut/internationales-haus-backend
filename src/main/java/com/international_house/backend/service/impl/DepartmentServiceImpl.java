package com.international_house.backend.service.impl;

import com.international_house.backend.entity.Department;
import com.international_house.backend.repository.DepartmentRepository;
import com.international_house.backend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(UUID departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Optional<Department> updateDepartment(UUID id, Department department) {
        return departmentRepository.updateDepartmentById(id, department);
    }
}
