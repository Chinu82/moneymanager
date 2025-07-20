package com.managemoney.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private String profileImgUrl;
    private LocalDateTime updatedAt;
}
