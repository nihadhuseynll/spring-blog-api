package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findBlogUserById(Integer id);

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
