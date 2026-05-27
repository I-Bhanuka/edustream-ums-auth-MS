package com.example.edustream_ums_auth_MS.dto.responseDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponseDTO {

    private String username;

    private String role;

    private String token;
}
