package com.example.springblogapi.model.request;

import com.example.springblogapi.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private Integer id;
    private String token;
    private String username;
    private String phoneNumber;
    private String email;
    private Boolean isVerified;
    private Gender sex;
    private String verificationToken;
    private Boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
