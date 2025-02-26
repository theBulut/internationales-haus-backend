package com.international_house.backend.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.international_house.backend.entity.Consultation;
import com.international_house.backend.repository.ConsultationRepository;
import com.international_house.backend.service.ConsultationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation getConsultation(Integer id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation Event not found with id: " + id));
    }

    public Consultation updateConsultation(Integer id, Consultation update) {
        return consultationRepository.updateConsultationById(id, update)
                .orElseThrow(() -> new EntityNotFoundException("Consultation Event not found with id: " + id));
    }

    public void deleteConsultation(Integer id) {
        consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation Event not found with id: " + id));
        consultationRepository.deleteById(id);
    }
}
