package com.international_house.backend.repos;

import com.international_house.backend.domain.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Employee, UUID> {
}
