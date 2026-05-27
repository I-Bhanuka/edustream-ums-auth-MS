package com.example.edustream_ums_auth_MS.service.impl;

import com.example.edustream_ums_auth_MS.client.UserServiceClient;
import com.example.edustream_ums_auth_MS.dto.requestDTO.LoginRequestDTO;
import com.example.edustream_ums_auth_MS.dto.responseDTO.LoginResponseDTO;
import com.example.edustream_ums_auth_MS.service.AuthService;
import com.example.edustream_ums_user_MS.dto.requestDTO.GetUserByUsernameRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceClient userServiceClient;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        log.info("================================ Login ==============================");

        log.info("Login Request details - Username: {}",
                loginRequestDTO.getUsername());


        UserResponseDTO responseDTO = userServiceClient.getByUsername(GetUserByUsernameRequestDTO.builder()
                .username(loginRequestDTO.getUsername())
                .build()).getData();


        if (responseDTO == null) {
            log.error("Login failed for username: {}. User not found.", loginRequestDTO.getUsername());
            throw new RuntimeException("Invalid username or password");
        }

        return LoginResponseDTO.builder()
                .username(responseDTO.getUsername())
                .role(responseDTO.getRole())
                .build();

    }

}
