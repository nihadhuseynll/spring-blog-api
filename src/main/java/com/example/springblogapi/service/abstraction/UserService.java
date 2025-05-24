package com.example.springblogapi.service.abstraction;

import com.example.springblogapi.dao.entity.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);
}
