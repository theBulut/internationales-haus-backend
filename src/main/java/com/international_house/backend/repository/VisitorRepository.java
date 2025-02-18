package com.international_house.backend.repository;

import com.international_house.backend.entity.Visitor;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
    @Modifying
    @Query("update Visitor v set v = ?2 where v.id = ?1")
    Optional<Visitor> updateVisitorById(UUID id, Visitor update);
}
