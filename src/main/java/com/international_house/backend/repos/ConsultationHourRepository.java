package com.international_house.backend.repos;

import com.international_house.backend.domain.ConsultationHour;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationHourRepository extends JpaRepository<ConsultationHour, UUID> {

}
