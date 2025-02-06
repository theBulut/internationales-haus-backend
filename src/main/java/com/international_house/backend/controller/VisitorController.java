package com.international_house.backend.controller;

import com.international_house.backend.domain.Visitor;
import com.international_house.backend.service.VisitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public void createVisitor(@RequestBody Visitor visitor){
        visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getVisitors(){
        return visitorService.getVisitors();
    }

    @GetMapping("/{id}")
    public Visitor getVisitorsByID(@PathVariable UUID id){
        return visitorService.getVisitorById(id).get();
    }

    @PutMapping("/{id}")
    public void updateConsultationHour( @PathVariable UUID id,@RequestBody Visitor update ) {
        visitorService.updateVisitor(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable UUID id){
        visitorService.deleteVisitorById(id);
    }
}
