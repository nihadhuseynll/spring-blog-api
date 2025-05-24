package com.example.springblogapi.mapper;

import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dto.CreatePostRequest;
import com.example.springblogapi.dto.UpdatePostRequest;
import com.example.springblogapi.dto.request.CreatePostRequestDto;
import com.example.springblogapi.dto.request.UpdatePostRequestDto;
import com.example.springblogapi.dto.response.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    PostResponseDto toPostResponseDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto updatePostRequestDto);
}
