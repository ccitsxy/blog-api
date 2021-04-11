package com.sxy.blog.service;

import com.sxy.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Page<Tag> findAll(Pageable pageable);

    Tag getTagByTid(Integer tid);

    void saveTag(Tag tag);
}
