package com.example.springblogapi.model.request;

import com.example.springblogapi.model.enums.Reactions;
import com.example.springblogapi.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {

    private String content;
    private UserType author;
    private Integer adminId;
    private Reactions reactions;
}
