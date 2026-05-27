package com.example.edustream_ums_auth_MS.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginRequestDTO {

    @NotBlank(message = "Username must not be blank")
    @NotNull(message = "Username must not be null")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @NotNull(message = "Password must not be null")
    private String password;
}
