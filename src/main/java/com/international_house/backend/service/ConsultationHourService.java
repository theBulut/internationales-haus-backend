package com.international_house.backend.service;

import com.international_house.backend.domain.ConsultationHour;
import com.international_house.backend.domain.ConsultingArea;
import com.international_house.backend.repos.ConsultationHourRepository;
import com.international_house.backend.repos.ConsultingAreaRepository;
import com.international_house.backend.request.ConsultationHourRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultationHourService {

    private final ConsultationHourRepository consultationHourRepository;
    private final ConsultingAreaRepository consultingAreaRepository;

    public ConsultationHourService(ConsultationHourRepository consultationHourRepository,
                                   ConsultingAreaRepository consultingAreaRepository) {
        this.consultationHourRepository = consultationHourRepository;
        this.consultingAreaRepository = consultingAreaRepository;

    }

    // Add ConsultationHour linked to a ConsultingArea by name
    @Transactional
    public void createConsultationHour(ConsultationHourRequest request) {
        // Retrieve the ConsultingArea by name
        ConsultingArea consultingArea = consultingAreaRepository.findByName(request.getAreaName());
        if (consultingArea == null) {
            throw new RuntimeException("ConsultingArea with name '" + request.getAreaName() + "' not found");
        }

        // Create a new ConsultationHour
        ConsultationHour consultationHour = ConsultationHour.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .explanation(request.getExplanation())
                .consultingArea(consultingArea)
                .build();

        // Save ConsultationHour
        consultationHourRepository.save(consultationHour);
    }


        public List<ConsultationHour> getAllConsultationHours () {
            return consultationHourRepository.findAll();
        }


    public Optional<ConsultationHour> getConsultationHourById(UUID consultationNumber) {
        return consultationHourRepository.findById(consultationNumber);
    }

    public ConsultationHour updateConsultationHour(UUID consultationNumber, ConsultationHour updatedConsultationHour) {
        return consultationHourRepository.findById(consultationNumber)
                .map(existingConsultationHour -> {
                    existingConsultationHour.setStartTime(updatedConsultationHour.getStartTime());
                    existingConsultationHour.setEndTime(updatedConsultationHour.getEndTime());
                    //existingConsultationHour.setConsultingArea(updatedConsultationHour.getConsultingArea());
                    return consultationHourRepository.save(existingConsultationHour);
                })
                .orElseThrow(() -> new EntityNotFoundException("ConsultationHour not found with id: " + consultationNumber));
    }

    public void deleteConsultationHour(UUID consultationNumber) {
        if (consultationHourRepository.existsById(consultationNumber)) {
            consultationHourRepository.deleteById(consultationNumber);
        } else {
            throw new EntityNotFoundException("ConsultationHour not found with id: " + consultationNumber);
        }
    }
    
}
