package com.example.springblogapi.dto;

import com.example.springblogapi.dto.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    String title;

    String content;

    UUID categoryId;

    @Builder.Default
    Set<UUID> tagIds = new HashSet<>();

    PostStatus status;
}
