package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {

    BlogUser findBlogUserById(Integer id);
    BlogUser findByEmail(String email);
    List<BlogUser> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
