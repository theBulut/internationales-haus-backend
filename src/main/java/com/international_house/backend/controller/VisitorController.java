package com.international_house.backend.controller;

import com.international_house.backend.domain.Visitor;
import com.international_house.backend.service.VisitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public void createVisitor(@RequestBody Visitor visitor) {
        visitorService.createVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getVisitors() {
        return visitorService.getVisitors();
    }

    @GetMapping("/timeStamp/{timeStamp}")
    public Visitor getVisitorsByTimeStamp(@PathVariable Long timeStamp) {
        return visitorService.getVisitorByTimeStamp(timeStamp).get();
    }

    @GetMapping("/{id}")
    public Visitor getVisitorsByID(@PathVariable Integer id) {
        return visitorService.getVisitorById(id).get();
    }

    @PutMapping("/{id}")
    public void updateConsultationHour(@PathVariable Integer id, @RequestBody Visitor update) {
        visitorService.updateVisitor(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable Integer id) {
        visitorService.deleteVisitorById(id);
    }
}
