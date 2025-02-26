package com.international_house.backend.service;

import com.international_house.backend.dto.request.CreateVisitorDto;
import com.international_house.backend.entity.Visitor;

import java.util.List;

public interface VisitorService {
    Visitor createVisitor(CreateVisitorDto visitor);

    Visitor getVisitor(Integer id);

    List<Visitor> getVisitors();

    Visitor updateVisitor(Integer id, Visitor update);

    void deleteVisitor(Integer visitorId);
}
