package com.international_house.backend.controller;

import com.international_house.backend.domain.Room;
import com.international_house.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/room")
public class RoomController {

    private final RoomService roomService;


    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    @PostMapping
    public void addNewRoom(@RequestBody Room room){
        roomService.addNewRoom(room);
    }

    @DeleteMapping
    public void deleteRoomById(@RequestBody Room room){
        roomService.deleteRoomById(room.getRoomId());
    }

    @PutMapping
    public void updateRoom(@RequestBody Room room){
        roomService.updateRoom(room.getRoomId(), room);
    }




}
