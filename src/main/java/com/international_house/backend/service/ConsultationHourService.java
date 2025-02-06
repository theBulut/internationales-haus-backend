package com.international_house.backend.service;

import com.international_house.backend.domain.ConsultationHour;
import com.international_house.backend.repos.ConsultationHourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultationHourService {

    private final ConsultationHourRepository consultationHourRepository;


    public ConsultationHourService(ConsultationHourRepository consultationHourRepository,
                                   TypeService typeService) {
        this.consultationHourRepository = consultationHourRepository;
    }

    public void createConsultationHour(ConsultationHour consultationHour) {
        consultationHourRepository.save(consultationHour);
    }


    public List<ConsultationHour> getAllConsultationHours () {
        return consultationHourRepository.findAll();
    }


    public Optional<ConsultationHour> getConsultationHourById(UUID id) {
        return consultationHourRepository.findById(id);
    }

    public void updateConsultationHour(UUID id, ConsultationHour update) {
        ConsultationHour hour = consultationHourRepository.findById(id).get();
        
        if( hour != null){
            hour.setStartTime(update.getStartTime());
            hour.setEndTime(update.getEndTime());
            hour.setDescription(update.getDescription());
            hour.setType(update.getType());
            hour.setIsCanceled(update.getIsCanceled());
            hour.setRepeat(update.getRepeat());
            hour.setReason(update.getReason());

            consultationHourRepository.save(hour);
        }
        else throw new EntityNotFoundException("ConsultationHour not found with id: " + id);
    }

    public void deleteConsultationHour(UUID id) {
        if (consultationHourRepository.existsById(id)) {
            consultationHourRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ConsultationHour not found with id: " + id);
        }
    }
    
}
