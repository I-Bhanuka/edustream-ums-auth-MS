package com.example.edustream_ums_auth_MS.service;

import com.example.edustream_ums_auth_MS.dto.requestDTO.LoginRequestDTO;
import com.example.edustream_ums_auth_MS.dto.responseDTO.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
