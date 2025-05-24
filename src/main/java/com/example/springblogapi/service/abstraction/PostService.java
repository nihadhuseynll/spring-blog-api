package com.example.springblogapi.service.abstraction;

import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dao.entity.User;
import com.example.springblogapi.dto.CreatePostRequest;
import com.example.springblogapi.dto.UpdatePostRequest;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getAllDrafts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
