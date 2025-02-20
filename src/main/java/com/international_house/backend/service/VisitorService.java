package com.international_house.backend.service;

import com.international_house.backend.dto.request.CreateVisitorDto;
import com.international_house.backend.entity.Visitor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VisitorService {
    Visitor createVisitor(CreateVisitorDto visitor);

    List<Visitor> getVisitors();

    Visitor getVisitorById(UUID id);

    Optional<Visitor> updateVisitor(UUID id, Visitor update);

    void deleteVisitorById(UUID visitorId);
}
