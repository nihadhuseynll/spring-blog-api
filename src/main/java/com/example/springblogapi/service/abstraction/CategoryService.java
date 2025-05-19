package com.example.springblogapi.service.abstraction;

import com.example.springblogapi.dao.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> listCategories();

    Category createCategory(Category category);

    void deleteCategory(UUID id);
}
