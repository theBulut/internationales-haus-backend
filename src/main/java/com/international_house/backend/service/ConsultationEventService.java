package com.international_house.backend.service;

import com.international_house.backend.domain.ConsultationEvent;
import com.international_house.backend.repos.ConsultationEventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultationEventService {

    private final ConsultationEventRepository consultationEventRepository;


    public ConsultationEventService(ConsultationEventRepository consultationEventRepository) {
        this.consultationEventRepository = consultationEventRepository;
    }

    public void createConsultationEvent(ConsultationEvent ConsultationEvent) {
        consultationEventRepository.save(ConsultationEvent);
    }

    public List<ConsultationEvent> getConsultationEvents () {
        return consultationEventRepository.findAll();
    }

    public Optional<ConsultationEvent> getConsultationEventById(UUID id) {
        return consultationEventRepository.findById(id);
    }

    public void updateConsultationEvent(UUID id, ConsultationEvent update) {
        ConsultationEvent event = consultationEventRepository.findById(id).get();
        
        if( event != null){
            event.setConsultation(update.getConsultation());
            event.setStartDate(update.getStartDate());
            event.setEndDate(update.getEndDate());
            event.setRepeat(update.getRepeat());
            event.setIsCanceled(update.getIsCanceled());
            event.setReason(update.getReason());

            consultationEventRepository.save(event);
        }
        else throw new EntityNotFoundException("ConsultationEvent not found with id: " + id);
    }

    public void deleteConsultationEvent(UUID id) {
        if (consultationEventRepository.existsById(id)) {
            consultationEventRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ConsultationEvent not found with id: " + id);
        }
    }
    
}
