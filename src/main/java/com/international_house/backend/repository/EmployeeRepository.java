package com.international_house.backend.repository;

import com.international_house.backend.entity.Employee;

import java.util.Optional;
import java.util.UUID;

import com.international_house.backend.enums.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByName(String username);

    //Todo this update does not allow to update all fields. It can just update the id .
    @Transactional
    @Modifying
    @Query("update Employee e set e = ?2 where e.id = ?1")
    int updateEmployeeById(UUID id, Employee update);

    @Query("select e from Employee e where e.role = ?1")
    Optional<Employee> getAdmin(Role role);
}
