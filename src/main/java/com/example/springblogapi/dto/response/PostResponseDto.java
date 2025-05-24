package com.example.springblogapi.dto.response;

import com.example.springblogapi.dto.enums.PostStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponseDto {

    UUID id;
    String title;
    String content;
    AuthorResponseDto author;
    CategoryResponseDto category;
    Set<TagResponseDto> tags;
    Integer readingTime;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    PostStatus postStatus;
}
