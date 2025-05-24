package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.Category;
import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dao.entity.Tag;
import com.example.springblogapi.dao.entity.User;
import com.example.springblogapi.dto.enums.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByStatus(PostStatus status);
    List<Post> findAllByAuthorAndStatus(User user, PostStatus status);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);
}
