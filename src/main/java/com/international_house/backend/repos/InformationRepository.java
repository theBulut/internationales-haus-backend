package com.international_house.backend.repos;

import com.international_house.backend.domain.Information;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {

    @Query("select i from Information i where i.language = ?1")
    Optional<Information> findByLanguage(String language);
}
