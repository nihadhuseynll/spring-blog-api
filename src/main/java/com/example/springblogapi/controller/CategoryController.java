package com.example.springblogapi.controller;

import com.example.springblogapi.dao.entity.Category;
import com.example.springblogapi.dto.request.CreateCategoryRequest;
import com.example.springblogapi.dto.response.CategoryResponseDto;
import com.example.springblogapi.mapper.CategoryMapper;
import com.example.springblogapi.service.abstraction.CategoryService;
import jakarta.validation.Valid;
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
@RequestMapping(path = "/api/v1/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;
    CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        List<CategoryResponseDto> categoryResponseDtoList = categoryService.listCategories()
                .stream().map(categoryMapper::toCategoryResponseDto).toList();

        return ResponseEntity.ok(categoryResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory
            (@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
                categoryMapper.toCategoryResponseDto(savedCategory),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
