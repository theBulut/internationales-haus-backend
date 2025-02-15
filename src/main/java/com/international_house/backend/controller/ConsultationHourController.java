package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.ConsultationHourEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.entity.ConsultationHour;
import com.international_house.backend.service.ConsultationHourService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = ConsultationHourEndpoint.API_TAG)
@RequestMapping(path = ConsultationHourEndpoint.BASE_URI)
public class ConsultationHourController {

    private final ConsultationHourService consultationHourService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> createConsultationHour(@RequestBody @Valid ConsultationHour consultationHour) {
        ConsultationHour createdConsultationHour = consultationHourService.createConsultationHour(consultationHour);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Consultation hour created successfully!").data(createdConsultationHour).build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getConsultationHours() {
        List<ConsultationHour> consultationHours = consultationHourService.getConsultationHours();
        return ResponseEntity.ok(BaseResponseDto.builder().message("Consultation hours retrieved successfully!").data(consultationHours).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> getConsultationHourById(@PathVariable UUID id) {
        ConsultationHour consultationHour = consultationHourService.getConsultationHourById(id);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Consultation hour retrieved successfully!").data(consultationHour).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateConsultationHour(@PathVariable UUID id, @RequestBody @Valid ConsultationHour update) {
        Optional<ConsultationHour> updatedConsultationHour = consultationHourService.updateConsultationHour(id, update);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Consultation hour updated successfully!").data(updatedConsultationHour).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteConsultationHour(@PathVariable UUID id) {
        consultationHourService.deleteConsultationHour(id);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Consultation hour deleted successfully!").build());
    }
}
