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


    public Optional<ConsultationHour> getConsultationHourById(UUID consultationNumber) {
        return consultationHourRepository.findById(consultationNumber);
    }

//    public ConsultationHour updateConsultationHour(UUID consultationNumber, ConsultationHour updatedConsultationHour) {
//        return consultationHourRepository.findById(consultationNumber)
//                .map(existingConsultationHour -> {
//                    existingConsultationHour.setStartTime(updatedConsultationHour.getStartTime());
//                    existingConsultationHour.setEndT(updatedConsultationHour.getEndT());
//                    //existingConsultationHour.setConsultingArea(updatedConsultationHour.getConsultingArea());
//                    return consultationHourRepository.save(existingConsultationHour);
//                })
//                .orElseThrow(() -> new EntityNotFoundException("ConsultationHour not found with id: " + consultationNumber));
//    }

    public void deleteConsultationHour(UUID consultationNumber) {
        if (consultationHourRepository.existsById(consultationNumber)) {
            consultationHourRepository.deleteById(consultationNumber);
        } else {
            throw new EntityNotFoundException("ConsultationHour not found with id: " + consultationNumber);
        }
    }
    
}
