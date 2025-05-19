package com.example.springblogapi.mapper;

import com.example.springblogapi.dao.entity.Category;
import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dto.enums.PostStatus;
import com.example.springblogapi.dto.request.CreateCategoryRequest;
import com.example.springblogapi.dto.response.CategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryResponseDto toCategoryResponseDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null || posts.isEmpty()) {
            return 0;
        }
        return posts.stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).count();
    }
}
