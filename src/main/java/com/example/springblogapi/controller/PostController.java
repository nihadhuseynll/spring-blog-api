package com.example.springblogapi.controller;

import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dao.entity.User;
import com.example.springblogapi.dto.CreatePostRequest;
import com.example.springblogapi.dto.request.CreatePostRequestDto;
import com.example.springblogapi.dto.response.PostResponseDto;
import com.example.springblogapi.mapper.PostMapper;
import com.example.springblogapi.service.abstraction.PostService;
import com.example.springblogapi.service.abstraction.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {

    PostMapper postMapper;
    UserService userService;
    PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts
            (@RequestParam(required = false) UUID categoryId,
             @RequestParam(required = false) UUID tagId) {
        List<PostResponseDto> postResponseDtoList = postService
                .getAllPosts(categoryId, tagId).stream().map(postMapper::toPostResponseDto).toList();

        return ResponseEntity.ok(postResponseDtoList);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostResponseDto>> getDrafts(@RequestAttribute UUID userId) {
        User loggedUser = userService.getUserById(userId);
        List<Post> posts = postService.getAllDrafts(loggedUser);
        List<PostResponseDto> postResponseDtoList = posts.stream().map(postMapper::toPostResponseDto).toList();
        return ResponseEntity.ok(postResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost
            (@RequestBody CreatePostRequestDto createPostRequestDto,
             @RequestAttribute UUID userId) {
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostResponseDto postResponseDto = postMapper.toPostResponseDto(createdPost);

        return new ResponseEntity<>(
                postResponseDto,
                HttpStatus.CREATED
        );
    }
}
