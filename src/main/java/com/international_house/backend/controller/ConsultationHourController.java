package com.international_house.backend.controller;

import com.international_house.backend.domain.ConsultationHour;
import com.international_house.backend.service.ConsultationHourService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path= "/api/consultations")
public class ConsultationHourController {
    
    private final ConsultationHourService consultationHourService;
    
    @Autowired
    public ConsultationHourController(ConsultationHourService consultationHourService) {
        this.consultationHourService = consultationHourService;
    }


    // Method to retrieve all ConsultationHours
    @GetMapping
    public List<ConsultationHour> getConsultationHours() {
        return consultationHourService.getAllConsultationHours();
    }
    
    
    // Method to create a new ConsultationHour
    @PostMapping
    public void createConsultationHour(@RequestBody ConsultationHour consultationHour) {
        consultationHourService.createConsultationHour(consultationHour);
    }

    // Method to delete a ConsultationHour by its ID
    @DeleteMapping("/{id}")
    public void deleteConsultationHour(@PathVariable UUID id) {
        consultationHourService.deleteConsultationHour(id);
    }

    // Method to update an existing ConsultationHour
//    @PutMapping("/{consultationNumber}")
//    public ConsultationHour updateConsultationHour(
//            @PathVariable UUID consultationNumber,
//            @RequestBody ConsultationHour updatedConsultationHour) {
//        return consultationHourService.updateConsultationHour(consultationNumber, updatedConsultationHour);
//    }


    // Method to retrieve a ConsultationHour by its ID
    @GetMapping("/{consultationNumber}")
    public ConsultationHour getConsultationHourById(@PathVariable UUID consultationNumber) {
        return consultationHourService.getConsultationHourById(consultationNumber)
                .orElseThrow(() -> new EntityNotFoundException("ConsultationHour not found with id: " + consultationNumber));
    }
    
    
}
