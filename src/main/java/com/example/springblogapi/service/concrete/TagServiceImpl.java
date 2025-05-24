package com.example.springblogapi.service.concrete;

import com.example.springblogapi.dao.entity.Tag;
import com.example.springblogapi.dao.repository.TagRepository;
import com.example.springblogapi.service.abstraction.TagService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;

    @Override
    public List<Tag> listTags() {
        return tagRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public List<Tag> createTags(Set<String> names) {
        List<Tag> existingTags = tagRepository.findByNameIn(names);
        Set<String> existingTagNames = existingTags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());

        List<Tag> newTags = names.stream().filter(name -> !existingTagNames.contains(name))
                .map(name -> Tag.builder()
                        .name(name)
                        .posts(new HashSet<>())
                        .build())
                .toList();

        List<Tag> savedTags = new ArrayList<>();

        if (!newTags.isEmpty()) {
            savedTags = tagRepository.saveAll(newTags);
        }

        savedTags.addAll(existingTags);
        return savedTags;
    }

    @Override
    public void deleteTag(UUID id) {
        tagRepository.findById(id).ifPresent(tag -> {
            if (!tag.getPosts().isEmpty()) {
                throw new IllegalStateException("Tag has posts associated with it");
            }
            tagRepository.deleteById(id);
        });
    }

    @Override
    public Tag getTagById(UUID id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with id: " + id));
    }

    @Override
    public List<Tag> getTagByIds(Set<UUID> ids) {
        List<Tag> foundTags = tagRepository.findAllById(ids);
        if (foundTags.size() != ids.size()) {
            throw new EntityNotFoundException("Not all specified tag IDs exist");
        }
        return foundTags;
    }
}
