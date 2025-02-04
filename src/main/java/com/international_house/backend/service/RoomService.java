package com.international_house.backend.service;

import com.international_house.backend.domain.Room;
import com.international_house.backend.repos.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {
    
    
    private final RoomRepository roomRepository;
    
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    
    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }
    
    public void createRoom(Room room) {
        roomRepository.save(room);
    }
    
    public void deleteRoomById(UUID roomId) {
        roomRepository.deleteById(roomId);
    }
    
    @Transactional 
    public void updateRoom(UUID roomId, Room updatedRoom) {

        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room with id " + roomId + " not found"));

        existingRoom.setRoomLabel(updatedRoom.getRoomLabel());

        roomRepository.save(existingRoom);
    }
}
