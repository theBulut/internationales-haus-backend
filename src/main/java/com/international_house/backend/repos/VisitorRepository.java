package com.international_house.backend.repos;

import com.international_house.backend.domain.Visitor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    @Query("select v from Visitor v where v.timeStamp = ?1")
    Optional<Visitor> findByTimeStamp(Long timeStamp);

}
