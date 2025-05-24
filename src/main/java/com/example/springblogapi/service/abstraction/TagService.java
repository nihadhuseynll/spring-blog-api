package com.example.springblogapi.service.abstraction;

import com.example.springblogapi.dao.entity.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {

    List<Tag> listTags();

    List<Tag> createTags(Set<String> names);

    void deleteTag(UUID id);

    Tag getTagById(UUID id);

    List<Tag> getTagByIds(Set<UUID> ids);
}
