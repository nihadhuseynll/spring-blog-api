package com.example.springblogapi.dao.entity;

import com.example.springblogapi.model.enums.Gender;
import com.example.springblogapi.model.enums.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String username;
    String password;

    @Column(unique = true)
    String email;
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    UserType userType;

    LocalDateTime createdDate;
    LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Reaction> reactions;
}
