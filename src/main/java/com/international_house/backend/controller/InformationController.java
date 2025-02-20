package com.international_house.backend.controller;

import com.international_house.backend.domain.Information;
import com.international_house.backend.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/information")
public class InformationController {

    private final InformationService InformationService;

    @Autowired
    public InformationController(InformationService InformationService) {
        this.InformationService = InformationService;
    }

    // Method to retrieve all Informations
    @GetMapping
    public List<Information> getInformations() {
        return InformationService.getInformations();
    }

    @GetMapping("/{language}")
    public Information getInformation(@PathVariable String language) {
        if (InformationService.getInformation(language).isPresent())
            return InformationService.getInformation(language).get();
        return new Information();

    }

    // Method to update an existing Information
    @PutMapping("/{language}")
    public void updateInformation(@PathVariable String language, @RequestBody Information update) {
        InformationService.updateInformation(language, update);
    }
}
