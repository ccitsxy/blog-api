package com.sxy.blog.service;

import com.sxy.blog.entity.Tag;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Page<Tag> findAll(Integer page, Integer size);

    Tag getTagByTid(Integer tid);

    void saveTag(Tag tag);

    void deleteTag(Integer tid);
}
