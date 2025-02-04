package com.international_house.backend.repos;

import com.international_house.backend.domain.ConsultingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultingAreaRepository extends JpaRepository<ConsultingArea, Integer> {

    ConsultingArea findByName(String name); // Add if needed for later lookup by name
}
