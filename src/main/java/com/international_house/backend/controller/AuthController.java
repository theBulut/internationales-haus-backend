package com.international_house.backend.controller;

import com.international_house.backend.controller.endpoint.AuthEndpoint;
import com.international_house.backend.core.security.jwt.JwtUtil;
import com.international_house.backend.dto.BaseResponseDto;
import com.international_house.backend.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.international_house.backend.core.security.CustomUserDetailsService;
import com.international_house.backend.dto.request.LoginRequestDto;
import com.international_house.backend.dto.request.SignUpDto;
import com.international_house.backend.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = AuthEndpoint.API_TAG)
@RequestMapping(AuthEndpoint.BASE_URI)
public class AuthController {

    private final AuthService authService;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    // TODO Remove It! It is the testing endpoint for DEVELOPMENT
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/signup")
    @Operation(summary = "Remove It! It is the testing endpoint for DEVELOPMENT")
    public ResponseEntity<BaseResponseDto> signup(@RequestBody @Valid SignUpDto signUpDto) {
        Employee employee = customUserDetailsService.registerUser(signUpDto);
        return ResponseEntity.ok(BaseResponseDto.builder().message("User created successfully").data(employee).build());
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponseDto> login(@RequestBody @Valid LoginRequestDto loginDto) {
        String token = authService.login(loginDto);
        return ResponseEntity.ok(BaseResponseDto.builder().message("User logged in successfully!").data(token).build());
    }

    @GetMapping("/profile")
    public ResponseEntity<BaseResponseDto> getProfile(@RequestHeader("Authorization") String token) {
        String employeeId = jwtUtil.extractUserId(token.substring(7));
        Employee employee = authService.getProfile(UUID.fromString(employeeId));
        return ResponseEntity
                .ok(BaseResponseDto.builder().message("Profile retrieved successfully!").data(employee).build());
    }
}
