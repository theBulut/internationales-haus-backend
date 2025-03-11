package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.InformationEndpoint;
import com.international_house.backend.controller.endpoint.VisitorEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.entity.Information;
import com.international_house.backend.service.InformationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = VisitorEndpoint.API_TAG)
@RequestMapping(path = InformationEndpoint.BASE_URI)
public class InformationController {

    private final InformationService InformationService;

    @GetMapping
    public ResponseEntity<BaseResponseDto> getInformations() {
        return ResponseEntity
                .ok(BaseResponseDto
                        .builder()
                        .data(InformationService.getInformations())
                        .message("Visitors retrieved successfully!")
                        .build());
    }

    @GetMapping("/{language}")
    public ResponseEntity<BaseResponseDto> getInformation(@PathVariable String language) {
        return ResponseEntity
                .ok(BaseResponseDto
                        .builder()
                        .data(InformationService.getInformation(language))
                        .message("Information retrieved successfully!")
                        .build());

    }

    // Method to update an existing Information
    @PutMapping("/{language}")
    public ResponseEntity<BaseResponseDto> updateInformation(@RequestHeader("Authorization") String token,
            @PathVariable String language,
            @Valid @RequestBody Information update) {
        InformationService.updateInformation(language, update);
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .message("Information updated successfully!")
                        .build());

    }
}
