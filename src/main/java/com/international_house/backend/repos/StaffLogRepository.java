package com.international_house.backend.repos;

import com.international_house.backend.domain.StaffLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffLogRepository extends JpaRepository<StaffLog, Long> {
}
