package com.international_house.backend.controller;

import com.international_house.backend.domain.Visitor;
import com.international_house.backend.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/visitor")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public List<Visitor> getVisitors(){
        return visitorService.getVisitors();
    }
    @PostMapping
    public void createVisitor(@RequestBody Visitor visitor){
        visitorService.createVisitor(visitor);
    }

    @DeleteMapping
    public void deleteVisitor(@RequestBody Visitor visitor){
        visitorService.deleteVisitorById(visitor.getVisitorId());
    }





}
