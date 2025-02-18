package com.international_house.backend.service;


import com.international_house.backend.entity.ConsultationHour;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultationHourService {
    ConsultationHour createConsultationHour(ConsultationHour consultationHour);

    List<ConsultationHour> getConsultationHours();

    ConsultationHour getConsultationHourById(UUID id);

    Optional<ConsultationHour> updateConsultationHour(UUID id, ConsultationHour update);

    void deleteConsultationHour(UUID consultationHourId);
}
