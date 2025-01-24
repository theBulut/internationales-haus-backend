package com.international_house.backend.repos;

import com.international_house.backend.domain.Staff;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, UUID> {
}
