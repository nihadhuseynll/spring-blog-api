package com.example.springblogapi.dao.entity;

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
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private UserType userType;
    private LocalDateTime createdDate;

    @OneToOne
    private BlogUser user;
    private Integer postId;
}
