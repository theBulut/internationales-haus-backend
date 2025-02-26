package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.VisitorEndpoint;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.dto.request.CreateVisitorDto;
import com.international_house.backend.entity.Visitor;
import com.international_house.backend.service.VisitorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = VisitorEndpoint.API_TAG)
@RequestMapping(path = VisitorEndpoint.BASE_URI)
public class VisitorController {

    private final VisitorService visitorService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> createVisitor(@Valid @RequestBody CreateVisitorDto visitor) {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .data(visitorService.createVisitor(visitor))
                        .message("Visitor created successfully!")
                        .build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getVisitors() {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .data(visitorService.getVisitors())
                        .message("Visitors retrieved successfully!")
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> getVisitor(@PathVariable Integer id) {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .data(visitorService.getVisitor(id))
                        .message("Visitor retrieved successfully!")
                        .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateVisitor(@PathVariable Integer id, @RequestBody Visitor update) {
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .data(visitorService.updateVisitor(id, update))
                        .message("Visitor updated successfully!")
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteVisitor(@PathVariable Integer id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity
                .ok(BaseResponseDto.builder()
                        .message("Visitor deleted successfully!")
                        .build());
    }
}
