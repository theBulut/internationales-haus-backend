package com.international_house.backend.repository;

import com.international_house.backend.entity.Employee;

import java.util.Optional;
import java.util.UUID;

import com.international_house.backend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByName(String username);

    @Modifying
    @Query("update Employee e set e = ?2 where e.id = ?1")
    Optional<Employee> updateEmployeeById(UUID id, Employee update);

    @Query("select e from Employee e where e.role = ?1")
    Optional<Employee> getAdmin(Role role);
}
