package com.example.springblogapi.dao.entity;


import com.example.springblogapi.model.enums.Gender;
import com.example.springblogapi.model.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blogusers")
public class BlogUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private UserType userType;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
