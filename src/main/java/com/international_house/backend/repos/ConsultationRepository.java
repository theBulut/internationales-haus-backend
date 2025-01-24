package com.international_house.backend.repos;

import com.international_house.backend.domain.Consultation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultationRepository extends JpaRepository<Consultation, UUID> {
}
