package com.international_house.backend.repos;

import com.international_house.backend.domain.Admin;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
