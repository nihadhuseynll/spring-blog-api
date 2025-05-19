package com.example.springblogapi.model.request;

import com.example.springblogapi.model.enums.Gender;
import com.example.springblogapi.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdminDto {

    @NotEmpty(message = "User name should not be empty.")
    private String username;

    @NotEmpty(message = "Email should not be empty.")
    private String email;

    @NotEmpty(message = "Password should not be empty.")
    private String password;

    @NotEmpty(message = "Gender should not be empty.")
    private Gender gender;

    @NotEmpty(message = "Please provide a user type.")
    private UserType roleType;
}
