package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);
    Post findPostByContent(String content);
}
