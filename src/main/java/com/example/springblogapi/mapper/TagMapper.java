package com.example.springblogapi.mapper;

import com.example.springblogapi.dao.entity.Post;
import com.example.springblogapi.dao.entity.Tag;
import com.example.springblogapi.dto.enums.PostStatus;
import com.example.springblogapi.dto.request.CreateTagsRequest;
import com.example.springblogapi.dto.response.TagResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    TagResponseDto toTagResponse(Tag tag);

    Tag toEntity(CreateTagsRequest createTagRequest);

    @Named("calculatePostCount")
    default Integer calculatePostCount(Set<Post> posts) {
        if(posts == null || posts.isEmpty()){
            return 0;
        }

        return (int) posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
