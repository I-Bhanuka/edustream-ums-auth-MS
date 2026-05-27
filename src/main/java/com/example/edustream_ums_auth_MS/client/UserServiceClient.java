package com.example.edustream_ums_auth_MS.client;

import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_ums_auth_MS.dto.requestDTO.LoginRequestDTO;
import com.example.edustream_ums_user_MS.dto.requestDTO.GetUserByUsernameRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class UserServiceClient {

    private final RestClient restClient;

    // The endpoints
    @Value("${services.user.api.create}")
    private String createUserEndpoint;

    @Value("${services.user.api.getByUsername}")
    private String getUserByUsernameEndpoint;

    @Value("${services.user.api.validateCredentials}")
    private String validateUserCredentialsEndpoint;

    public UserServiceClient(@Qualifier("userRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public ApiResponse<UserResponseDTO> getByUsername(GetUserByUsernameRequestDTO getUserByUsernameRequestDTO) {
        log.info("Calling the User Service's {} URI to get user details for username: {}",
                getUserByUsernameEndpoint, getUserByUsernameRequestDTO.getUsername());

        return restClient.post()
                .uri(getUserByUsernameEndpoint)
                .body(getUserByUsernameRequestDTO)
                .retrieve()
                .body( new ParameterizedTypeReference<>() {
        });

    }

    public ApiResponse<UserResponseDTO> validateUserCredentials(LoginRequestDTO loginRequestDTO) {
        log.info("Calling the User Service's {} URI to validate user credentials for username: {}",
                validateUserCredentialsEndpoint, loginRequestDTO.getUsername());

        return restClient.post()
                .uri(validateUserCredentialsEndpoint)
                .body(loginRequestDTO)
                .retrieve()
                .body( new ParameterizedTypeReference<>() {
        });

    }
}
