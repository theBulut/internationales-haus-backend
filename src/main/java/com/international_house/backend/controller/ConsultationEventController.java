package com.international_house.backend.controller;

import com.international_house.backend.domain.ConsultationEvent;
import com.international_house.backend.service.ConsultationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/consultation/events")
public class ConsultationEventController {

    private final ConsultationEventService ConsultationEventService;

    @Autowired
    public ConsultationEventController(ConsultationEventService ConsultationEventService) {
        this.ConsultationEventService = ConsultationEventService;
    }

    // Method to create a new ConsultationEvent
    @PostMapping
    public void createConsultationEvent(@RequestBody ConsultationEvent ConsultationEvent) {
        ConsultationEventService.createConsultationEvent(ConsultationEvent);
    }

    // Method to retrieve all ConsultationEvents
    @GetMapping
    public List<ConsultationEvent> getConsultationEvents() {
        return ConsultationEventService.getConsultationEvents();
    }

    // Method to retrieve a ConsultationEvent by its ID
    @GetMapping("/{id}")
    public ConsultationEvent getConsultationEventById(@PathVariable UUID id) {
        return ConsultationEventService.getConsultationEventById(id).get();
    }

    // Method to update an existing ConsultationEvent
    @PutMapping("/{id}")
    public void updateConsultationEvent(@PathVariable UUID id, @RequestBody ConsultationEvent update) {
        ConsultationEventService.updateConsultationEvent(id, update);
    }

    // Method to delete a ConsultationEvent by its ID
    @DeleteMapping("/{id}")
    public void deleteConsultationEvent(@PathVariable UUID id) {
        ConsultationEventService.deleteConsultationEvent(id);
    }
}
