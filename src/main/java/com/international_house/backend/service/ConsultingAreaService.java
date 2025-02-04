package com.international_house.backend.service;

import com.international_house.backend.domain.ConsultingArea;
import com.international_house.backend.repos.ConsultingAreaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ConsultingAreaService {
    
    private final ConsultingAreaRepository consultingAreaRepository;
    
    public ConsultingAreaService(ConsultingAreaRepository consultingAreaRepository) {
        this.consultingAreaRepository = consultingAreaRepository;
    }
    
    @GetMapping
    public List<ConsultingArea> getConsultationAreas() {
        return consultingAreaRepository.findAll();
    }
    

    public void createConsultationArea(ConsultingArea consultingArea) {
        consultingAreaRepository.save(consultingArea);
    }
    
    @Transactional
    public void updateConsultationArea(Integer consultingAreaId, ConsultingArea newConsultingArea) {
        ConsultingArea existingConsultingArea = consultingAreaRepository.findById(consultingAreaId)
                .orElseThrow(() -> new IllegalStateException("Consulting Area with ID " + consultingAreaId + " does not exist"));
        existingConsultingArea.setName(newConsultingArea.getName());
        consultingAreaRepository.save(existingConsultingArea);
    }
    
    

    public void deleteConsultationAreaById(Integer consultingAreaId) {
        consultingAreaRepository.deleteById(consultingAreaId);
    }

    public ConsultingArea getConsultingAreaById(Integer consultingAreaId) {
        return consultingAreaRepository.findById(consultingAreaId)
                .orElseThrow(() -> new EntityNotFoundException("ConsultingArea not found with ID " + consultingAreaId));
    }
    
}
