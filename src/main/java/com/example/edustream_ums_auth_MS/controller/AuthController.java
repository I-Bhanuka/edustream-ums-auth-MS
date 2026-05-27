package com.example.edustream_ums_auth_MS.controller;

import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_ums_auth_MS.dto.requestDTO.LoginRequestDTO;
import com.example.edustream_ums_auth_MS.dto.responseDTO.LoginResponseDTO;
import com.example.edustream_ums_auth_MS.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public String healthCheck() {
        return "Auth Service is up and running!";
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(
            @Valid @RequestBody LoginRequestDTO loginRequestDTO) {

        log.info("Login request received: {}", loginRequestDTO);

        LoginResponseDTO responseDTO = authService.login(loginRequestDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "Login successful"));

    }
}
