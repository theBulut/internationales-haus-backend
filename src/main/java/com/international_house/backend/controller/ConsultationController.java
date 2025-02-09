package com.international_house.backend.controller;

import com.international_house.backend.domain.Consultation;
import com.international_house.backend.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public void createConsultation(@RequestBody Consultation consultation){
        consultationService.createConsultation(consultation);
    }

    @GetMapping
    public List<Consultation> getConsultations(){
        return consultationService.getConsultations();
    }

    @GetMapping("/{id}")
    public Optional<Consultation> getConsultationById(Integer id){
        return consultationService.getConsultationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@RequestBody Integer consultationId){
        consultationService.deleteConsultationById(consultationId);
    }

    @PutMapping("/{id}")
    public void updateConsulting(@RequestBody Consultation consultation){
        consultationService.updateConsultation(consultation.getId(), consultation);
    }
}
