package com.international_house.backend.service;

import com.international_house.backend.domain.Consultation;
import com.international_house.backend.repos.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {
    
    private final ConsultationRepository consultationRepository;
    
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public void createConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public List<Consultation> getConsultations () {
        return consultationRepository.findAll();
    }
    
    public Optional<Consultation> getConsultationById(Integer id) {
        return consultationRepository.findById(id);
    }
    
    public void updateConsultation(Integer id, Consultation update) {
        Consultation consultation = consultationRepository.findById(id).get();
        
        if( consultation != null){
            consultation.setName(update.getName());
            consultation.setDescription(update.getDescription());
            consultation.setShortVersion(update.getShortVersion());
            consultation.setColor(update.getColor());

            consultationRepository.save(consultation);
        }
        else throw new EntityNotFoundException("ConsultationEvent not found with id: " + id);
    }

    public void deleteConsultationById(Integer id) {
        if (consultationRepository.existsById(id)) {
            consultationRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ConsultationEvent not found with id: " + id);
        }
    }
}
