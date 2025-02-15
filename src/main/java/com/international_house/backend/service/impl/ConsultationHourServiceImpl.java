package com.international_house.backend.service.impl;

import com.international_house.backend.entity.ConsultationHour;
import com.international_house.backend.repository.ConsultationHourRepository;
import com.international_house.backend.service.ConsultationHourService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ConsultationHourServiceImpl implements ConsultationHourService {

    private final ConsultationHourRepository consultationHourRepository;


    public ConsultationHour createConsultationHour(ConsultationHour consultationHour) {
        return consultationHourRepository.save(consultationHour);
    }

    public List<ConsultationHour> getConsultationHours() {
        return consultationHourRepository.findAll();
    }

    public ConsultationHour getConsultationHourById(UUID id) {
        return consultationHourRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ConsultationHour not found with id: " + id));
    }

    public Optional<ConsultationHour> updateConsultationHour(UUID id, ConsultationHour update) {
        return consultationHourRepository.updateConsultationHourById(id, update);
    }

    public void deleteConsultationHour(UUID id) {
        consultationHourRepository.deleteById(id);
    }

}
