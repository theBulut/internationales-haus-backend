package com.international_house.backend.repository;

import com.international_house.backend.entity.ConsultationHour;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationHourRepository extends JpaRepository<ConsultationHour, UUID> {

    @Modifying
    @Query("update ConsultationHour c set c = ?2 where c.id = ?1")
    Optional<ConsultationHour> updateConsultationHourById(UUID id, ConsultationHour update);
}
