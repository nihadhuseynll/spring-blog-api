package com.example.springblogapi.dao.entity;

import com.example.springblogapi.model.enums.Reactions;
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
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private UserType author;
    private int postView;
    private LocalDateTime createdDate;
    private Integer adminId;
    private Reactions reactions;
}
