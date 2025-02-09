package com.international_house.backend.service;

import com.international_house.backend.domain.Visitor;
import com.international_house.backend.repos.VisitorRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public void createVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    public Optional<Visitor> getVisitorById(UUID id) {
        return visitorRepository.findById(id);
    }

    public void updateVisitor(UUID id, Visitor update) {
        Visitor visitor = visitorRepository.findById(id).get();
        if( visitor != null){
            visitor.setTimeStamp(update.getTimeStamp());
            visitor.setConsultation(update.getConsultation());
            visitor.setBeingCalled(update.getBeingCalled());

            visitorRepository.save(visitor);
        }
        else throw new EntityNotFoundException("ConsultationHour not found with id: " + id);
    }

    public void deleteVisitorById(UUID visitorId) {
        visitorRepository.deleteById(visitorId);
    }

}
