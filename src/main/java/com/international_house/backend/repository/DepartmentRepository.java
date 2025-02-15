package com.international_house.backend.repository;

import com.international_house.backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    @Modifying
    @Query("UPDATE Department d SET d = :department WHERE d.id = :id")
    Optional<Department> updateDepartmentById(UUID id, Department department);
}
