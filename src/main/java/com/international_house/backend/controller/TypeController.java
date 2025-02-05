package com.international_house.backend.controller;

import com.international_house.backend.domain.ConsultingArea;
import com.international_house.backend.service.ConsultingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void addNewConsultingArea(@RequestBody ConsultingArea consultingArea){
        consultingAreaService.addNewConsultationArea(consultingArea);
    }

    @DeleteMapping
    public void deleteConsultingAreaById(@RequestBody Integer consultingAreaId){
        consultingAreaService.deleteConsultationAreaById(consultingAreaId);
    }

    @PutMapping
    public void updateConsultingArea(@RequestBody ConsultingArea consultingArea){
        consultingAreaService.updateConsultationArea(consultingArea.getConsultingAreaId(), consultingArea);
    }

}
