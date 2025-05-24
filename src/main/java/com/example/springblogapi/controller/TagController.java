package com.example.springblogapi.controller;

import com.example.springblogapi.dao.entity.Tag;
import com.example.springblogapi.dto.request.CreateTagsRequest;
import com.example.springblogapi.dto.response.TagResponseDto;
import com.example.springblogapi.mapper.TagMapper;
import com.example.springblogapi.service.abstraction.TagService;
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
@RequestMapping("/api/v1/tags")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagController {

    TagService tagService;
    TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponseDto>> getAllTags() {
        List<TagResponseDto> tagResponseDtoList = tagService.listTags()
                .stream().map(tagMapper::toTagResponse).toList();

        return ResponseEntity.ok(tagResponseDtoList);
    }

    @PostMapping
    public ResponseEntity<List<TagResponseDto>> createTags(@RequestBody CreateTagsRequest createTagsRequest) {
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
        List<TagResponseDto> createdTagResponsDtos = savedTags.stream().map(tagMapper::toTagResponse).toList();

        return new ResponseEntity<>(
                createdTagResponsDtos,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
