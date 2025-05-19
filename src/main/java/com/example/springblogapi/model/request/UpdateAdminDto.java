package com.example.springblogapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminDto {

    private int id;
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
}
