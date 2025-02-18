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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = VisitorEndpoint.API_TAG)
@RequestMapping(path = VisitorEndpoint.BASE_URI)
public class VisitorController {

    private final VisitorService visitorService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> createVisitor(@Valid @RequestBody CreateVisitorDto visitor) {
        Visitor createdVisitor = visitorService.createVisitor(visitor);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Visitor created successfully!").data(createdVisitor).build());
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getVisitors() {
        List<Visitor> visitors = visitorService.getVisitors();
        return ResponseEntity.ok(BaseResponseDto.builder().message("Visitors retrieved successfully!").data(visitors).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDto> getVisitorsByID(@PathVariable UUID id) {
        Visitor visitor = visitorService.getVisitorById(id);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Visitor retrieved successfully!").data(visitor).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateConsultationHour(@PathVariable UUID id, @RequestBody Visitor update) {
        Optional<Visitor> updatedVisitor = visitorService.updateVisitor(id, update);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Visitor updated successfully!").data(updatedVisitor).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteVisitor(@PathVariable UUID id) {
        visitorService.deleteVisitorById(id);
        return ResponseEntity.ok(BaseResponseDto.builder().message("Visitor deleted successfully!").build());
    }
}
