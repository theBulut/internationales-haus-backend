package com.international_house.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.international_house.backend.entity.Visitor;
import com.international_house.backend.service.VisitorService;
import com.international_house.backend.repository.VisitorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor getVisitor(Integer id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with id: " + id));
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    @Transactional
    public void updateVisitor(Integer id, Visitor update) {
        if (visitorRepository.findById(id).isPresent())
            visitorRepository.save(update);
    }

    public void deleteVisitor(Integer id) {
        visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with id: " + id));
        visitorRepository.deleteById(id);
    }
}
