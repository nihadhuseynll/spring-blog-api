package com.example.springblogapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostViewDto {

    private Integer userId;
    private Integer postId;
    private LocalDateTime timeDuration;
}
