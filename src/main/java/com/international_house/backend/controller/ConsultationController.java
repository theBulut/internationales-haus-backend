package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.ConsultationEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.entity.Consultation;
import com.international_house.backend.service.ConsultationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = ConsultationEndpoint.API_TAG)
@RequestMapping(path = ConsultationEndpoint.BASE_URI)
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> createConsultation(@Valid @RequestBody Consultation consultation) {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .message("Consultation created successfully!")
                        .data(consultationService.createConsultation(consultation))
                        .build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getConsultations() {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .data(consultationService.getConsultations())
                        .message("Consultations retrieved successfully!")
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> getConsultationById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(BaseResponseDto
                        .builder()
                        .data(consultationService.getConsultation(id))
                        .message("Consultations retrieved successfully!")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateConsulting(@PathVariable Integer id,
            @RequestBody Consultation consultation) {
        consultationService.updateConsultation(id, consultation);
        return ResponseEntity
                .ok(BaseResponseDto
                        .builder()
                        .message("Consultation updated successfully!")
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteConsultation(@PathVariable Integer id) {
        consultationService.deleteConsultation(id);
        return ResponseEntity
                .ok(BaseResponseDto
                        .builder()
                        .message("Consultation deleted successfully!:")
                        .build());
    }
}
