package com.international_house.backend.controller;

import com.international_house.backend.domain.ConsultingArea;
import com.international_house.backend.response.ConsultingAreaResponse;
import com.international_house.backend.service.ConsultingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/consultingArea")
public class ConsultingAreaController {

    private final ConsultingAreaService consultingAreaService;

    @Autowired
    public ConsultingAreaController(ConsultingAreaService consultingAreaService) {
        this.consultingAreaService = consultingAreaService;
    }

    @GetMapping
    public List<ConsultingArea> getConsultingAreas(){
        return consultingAreaService.getConsultationAreas();
    }

    @GetMapping("/{areaName}/consultation-hours")
    public ResponseEntity<ConsultingAreaResponse> getConsultingAreaWithConsultationHours(
            @PathVariable String areaName) {
        ConsultingAreaResponse response = consultingAreaService.getConsultingAreaWithConsultationHours(areaName);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> createConsultingArea(@RequestBody ConsultingArea consultingArea) {
        consultingAreaService.createConsultingArea(consultingArea);
        return ResponseEntity.ok("ConsultingArea created successfully!");
    }

    @DeleteMapping
    public void deleteConsultingAreaById(@RequestBody Integer consultingAreaId){
        consultingAreaService.deleteConsultingAreaById(consultingAreaId);
    }

    @PutMapping
    public void updateConsultingArea(@RequestBody ConsultingArea consultingArea){
        consultingAreaService.updateConsultingArea(consultingArea.getConsultingAreaId(), consultingArea);
    }

}
