package com.international_house.backend.repos;

import com.international_house.backend.domain.ConsultationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ConsultationEventRepository extends JpaRepository<ConsultationEvent, UUID> {

}
