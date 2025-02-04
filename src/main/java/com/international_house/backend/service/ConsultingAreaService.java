package com.international_house.backend.service;

import com.international_house.backend.domain.ConsultingArea;
import com.international_house.backend.repos.ConsultingAreaRepository;
import com.international_house.backend.response.ConsultationHourResponse;
import com.international_house.backend.response.ConsultingAreaResponse;
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
    

    public void createConsultingArea(ConsultingArea consultingArea) {
        consultingAreaRepository.save(consultingArea);
    }
    
    @Transactional
    public void updateConsultingArea(Integer consultingAreaId, ConsultingArea newConsultingArea) {
        ConsultingArea existingConsultingArea = consultingAreaRepository.findById(consultingAreaId)
                .orElseThrow(() -> new IllegalStateException("Consulting Area with ID " + consultingAreaId + " does not exist"));
        existingConsultingArea.setName(newConsultingArea.getName());
        consultingAreaRepository.save(existingConsultingArea);
    }
    
    

    public void deleteConsultingAreaById(Integer consultingAreaId) {
        consultingAreaRepository.deleteById(consultingAreaId);
    }

    public ConsultingArea getConsultingAreaById(Integer consultingAreaId) {
        return consultingAreaRepository.findById(consultingAreaId)
                .orElseThrow(() -> new EntityNotFoundException("ConsultingArea not found with ID " + consultingAreaId));
    }

    @Transactional
    public ConsultingAreaResponse getConsultingAreaWithConsultationHours(String name) {
        // Find ConsultingArea by name
        ConsultingArea consultingArea = consultingAreaRepository.findByName(name);
        if (consultingArea == null) {
            throw new RuntimeException("ConsultingArea with name '" + name + "' not found");
        }

        // Prepare DTO response to return
        ConsultingAreaResponse response = new ConsultingAreaResponse();
        response.setConsultingAreaName(consultingArea.getName());

        // Map ConsultationHours to DTOs for response
        response.setConsultationHours(
                consultingArea.getConsultationHours().stream()
                        .map(consultationHour -> {
                            ConsultationHourResponse hourResponse = new ConsultationHourResponse();
                            hourResponse.setStartTime(consultationHour.getStartTime());
                            hourResponse.setEndTime(consultationHour.getEndTime());
                            hourResponse.setExplanation(consultationHour.getExplanation());
                            return hourResponse;
                        }).toList()
        );

        return response;
    }
    
}
