package com.international_house.backend.repos;

import com.international_house.backend.domain.Room;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, UUID> {
}
