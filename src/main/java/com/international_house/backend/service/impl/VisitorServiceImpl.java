package com.international_house.backend.service.impl;

import com.international_house.backend.dto.request.CreateVisitorDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import com.international_house.backend.entity.Visitor;
import com.international_house.backend.service.VisitorService;
import com.international_house.backend.repository.VisitorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {

    private final ModelMapper modelMapper;
    private final VisitorRepository visitorRepository;

    public Visitor createVisitor(CreateVisitorDto visitor) {
        return visitorRepository.save(modelMapper.map(visitor, Visitor.class));
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(UUID id) {
        return visitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visitor not found with id: " + id));
    }

    public Optional<Visitor> updateVisitor(UUID id, Visitor payload) {
        return visitorRepository.updateVisitorById(id, payload);
    }

    public void deleteVisitorById(UUID visitorId) {
        this.getVisitorById(visitorId);
        visitorRepository.deleteById(visitorId);
    }

}

