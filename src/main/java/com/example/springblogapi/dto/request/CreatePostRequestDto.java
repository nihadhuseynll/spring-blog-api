package com.example.springblogapi.dto.request;

import com.example.springblogapi.dto.enums.PostStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePostRequestDto {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between {min} and {max} characters")
    String title;

    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 50000, message = "Content must be between {min} and {max} characters")
    String content;

    UUID categoryId;

    @Builder.Default
    @Size(max = 10, message = "Maximum {max} tags allowed")
    Set<UUID> tagIds = new HashSet<>();

    @NotNull(message = "Status is required")
    PostStatus status;
}
