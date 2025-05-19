package com.example.springblogapi.dao.repository;

import com.example.springblogapi.dao.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Integer> {
}
