package com.example.springblogapi.dao.entity;

import com.example.springblogapi.model.enums.ReactionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reactions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Enumerated(EnumType.STRING)
    ReactionType reactionType;

    LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = true)
    Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = true)
    Comment comment;

    @PrePersist
    @PreUpdate
    void validateTarget() {
        boolean postSet = post != null;
        boolean commentSet = comment != null;

        if (postSet == commentSet) {
            throw new IllegalArgumentException("Reaction must be related to either a post or a comment, but not both.");
        }
    }
}
