package com.international_house.backend.controller;

import com.international_house.backend.domain.ConsultationHour;
import com.international_house.backend.service.ConsultationHourService;
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

     // Method to create a new ConsultationHour
     @PostMapping
     public void createConsultationHour(@RequestBody ConsultationHour consultationHour) {
         consultationHourService.createConsultationHour(consultationHour);
     }

    // Method to retrieve all ConsultationHours
    @GetMapping
    public List<ConsultationHour> getConsultationHours() {
        return consultationHourService.getAllConsultationHours();
    }

     // Method to retrieve a ConsultationHour by its ID
     @GetMapping("/{id}")
     public ConsultationHour getConsultationHourById(@PathVariable UUID id) {
         return consultationHourService.getConsultationHourById(id).get();
     }
    
    // Method to update an existing ConsultationHour
    @PutMapping("/{id}")
    public void updateConsultationHour( @PathVariable UUID id,@RequestBody ConsultationHour update ) {
        consultationHourService.updateConsultationHour(id, update);
    }

    // Method to delete a ConsultationHour by its ID
    @DeleteMapping("/{id}")
    public void deleteConsultationHour(@PathVariable UUID id) {
        consultationHourService.deleteConsultationHour(id);
    }
}
