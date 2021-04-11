package com.sxy.blog.service.impl;

import com.sxy.blog.entity.Tag;
import com.sxy.blog.repository.TagRepository;
import com.sxy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Page<Tag> findAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag getTagByTid(Integer tid) {
        return tagRepository.getTagByTid(tid);
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }
}
