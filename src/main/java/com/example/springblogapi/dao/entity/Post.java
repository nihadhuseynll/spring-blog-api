package com.example.springblogapi.dao.entity;

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
@Table(name = "posts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String content;
    int postView;

    LocalDateTime createdDate;
    LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Reaction> reactions;
}
