package com.international_house.backend.controller;

import com.international_house.backend.domain.Type;
import com.international_house.backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> getTypes(){
        return typeService.getConsultationAreas();
    }

    @PostMapping
    public void createType(@RequestBody Type type){
        typeService.addNewConsultationArea(type);
    }

    @DeleteMapping
    public void deleteType(@RequestBody Integer consultingAreaId){
        typeService.deleteConsultationAreaById(consultingAreaId);
    }

    @PutMapping
    public void updateConsultingArea(@RequestBody Type type){
        typeService.updateConsultationArea(type.getId(), type);
    }

}
