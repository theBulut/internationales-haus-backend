package com.international_house.backend.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.international_house.backend.entity.ConsultationEvent;

@Repository
public interface ConsultationEventRepository extends JpaRepository<ConsultationEvent, UUID> {
    @Modifying
    @Query("UPDATE ConsultationEvent c SET c = ?2 WHERE c.id = ?1")
    Optional<ConsultationEvent> updateConsultationHourById(UUID id, ConsultationEvent update);
}
