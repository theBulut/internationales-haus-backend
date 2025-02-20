package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.DepartmentEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.entity.Department;
import com.international_house.backend.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = DepartmentEndpoint.API_TAG)
@RequestMapping(path = DepartmentEndpoint.BASE_URI)
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<BaseResponseDto> createDepartment(@RequestBody @Valid Department type) {
        Department department = departmentService.createDepartment(type);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Department created successfully!").data(department).build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        return ResponseEntity.ok(BaseResponseDto.builder().message("Departments retrieved successfully!").data(departments).build());
    }

    @DeleteMapping
    public ResponseEntity<BaseResponseDto> deleteDepartment(@RequestBody UUID consultingAreaId) {
        departmentService.deleteDepartment(consultingAreaId);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Department deleted successfully!:").build());
    }

    @PutMapping
    public ResponseEntity<BaseResponseDto> updateDepartment(@RequestBody Department type) {
        Optional<Department> updatedDepartment = departmentService.updateDepartment(type.getId(), type);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Department updated successfully!").data(updatedDepartment).build());
    }

}
