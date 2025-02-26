package com.international_house.backend.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.international_house.backend.entity.ConsultationEvent;
import com.international_house.backend.repository.ConsultationEventRepository;
import com.international_house.backend.service.ConsultationEventService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultationEventServiceImpl implements ConsultationEventService {

    private final ConsultationEventRepository consultationEventRepository;

    public ConsultationEvent createConsultationEvent(ConsultationEvent ConsultationEvent) {
        return consultationEventRepository.save(ConsultationEvent);
    }

    public List<ConsultationEvent> getConsultationEvents() {
        return consultationEventRepository.findAll();
    }

    public ConsultationEvent getConsultationEvent(UUID id) {
        return consultationEventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ConsultationEvent not found with id: " + id));
    }

    public ConsultationEvent updateConsultationEvent(UUID id, ConsultationEvent update) {
        return consultationEventRepository.updateConsultationHourById(id, update)
                .orElseThrow(() -> new EntityNotFoundException("ConsultationEvent not found with id: " + id));
    }

    public void deleteConsultationEvent(UUID id) {
        consultationEventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ConsultationEvent not found with id: " + id));
        consultationEventRepository.deleteById(id);
    }

}
