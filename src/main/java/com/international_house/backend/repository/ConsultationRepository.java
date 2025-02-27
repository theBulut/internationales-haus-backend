package com.international_house.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.international_house.backend.entity.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Consultation e SET e = ?2 WHERE e.id = ?1")
    int updateConsultationById(Integer id, Consultation update);
}
