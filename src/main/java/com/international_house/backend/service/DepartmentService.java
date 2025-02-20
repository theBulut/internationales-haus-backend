package com.international_house.backend.service;

import com.international_house.backend.entity.Department;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentService {

    Department createDepartment(Department type);

    List<Department> getDepartments();

    void deleteDepartment(UUID consultingAreaId);

    Optional<Department> updateDepartment(UUID id, Department type);
}
