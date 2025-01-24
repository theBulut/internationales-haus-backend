package com.international_house.backend.repos;

import com.international_house.backend.domain.ConsultationLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultationLogRepository extends JpaRepository<ConsultationLog, Integer> {
}
