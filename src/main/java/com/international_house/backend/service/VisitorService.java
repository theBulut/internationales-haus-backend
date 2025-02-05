package com.international_house.backend.service;

import com.international_house.backend.domain.Visitor;
import com.international_house.backend.repos.VisitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;


@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @GetMapping
    public List<Visitor> getVisitors() {

        return visitorRepository.findAll();

    }

    public void createVisitor(Visitor visitor) {

        visitorRepository.save(visitor);
    }


    public void deleteVisitorById(UUID visitorId) {
        visitorRepository.deleteById(visitorId);
    }

}
