package com.international_house.backend.service;

import com.international_house.backend.domain.Type;
import com.international_house.backend.repos.TypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TypeService {
    
    private final TypeRepository typeRepository;
    
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    
    @GetMapping
    public List<Type> getConsultationAreas() {
        return typeRepository.findAll();
    }
    

    public void addNewConsultationArea(Type type) {
        typeRepository.save(type);
    }
    
    @Transactional
    public void updateConsultationArea(Integer consultingAreaId, Type newType) {
        Type existingType = typeRepository.findById(consultingAreaId)
                .orElseThrow(() -> new IllegalStateException("Consulting Area with ID " + consultingAreaId + " does not exist"));
        existingType.setName(newType.getName());
        typeRepository.save(existingType);
    }
    
    

    public void deleteConsultationAreaById(Integer consultingAreaId) {
        typeRepository.deleteById(consultingAreaId);
    }

    public Type getConsultingAreaById(Integer consultingAreaId) {
        return typeRepository.findById(consultingAreaId)
                .orElseThrow(() -> new EntityNotFoundException("ConsultingArea not found with ID " + consultingAreaId));
    }
    
}
