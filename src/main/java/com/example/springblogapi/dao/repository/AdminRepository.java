package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.Admin;
import com.example.springblogapi.dao.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminById(Integer id);

    List<Admin> findAll();

    boolean existsByUsername(String username);

    Admin findByUser(BlogUser user);
}
