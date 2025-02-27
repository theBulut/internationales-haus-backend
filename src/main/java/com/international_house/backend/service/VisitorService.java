package com.international_house.backend.service;

import com.international_house.backend.entity.Visitor;
import jakarta.transaction.Transactional;

import java.util.List;

public interface VisitorService {
    Visitor createVisitor(Visitor visitor);

    Visitor getVisitor(Integer id);

    List<Visitor> getVisitors();

    @Transactional
    void updateVisitor(Integer id, Visitor update);

    void deleteVisitor(Integer visitorId);
}
