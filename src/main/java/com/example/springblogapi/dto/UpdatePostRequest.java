package com.example.springblogapi.dto;

import com.example.springblogapi.dto.enums.PostStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePostRequest {

    UUID id;

    String title;

    String content;

    UUID categoryId;

    @Builder.Default
    Set<UUID> tagIds = new HashSet<>();

    PostStatus status;
}
