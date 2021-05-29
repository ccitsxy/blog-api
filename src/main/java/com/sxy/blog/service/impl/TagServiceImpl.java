package com.sxy.blog.service.impl;

import com.sxy.blog.constant.JsonPage;
import com.sxy.blog.entity.Tag;
import com.sxy.blog.repository.TagRepository;
import com.sxy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Tag> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("tid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(tagRepository.findAll(pr), pr);
    }

    @Override
    public Tag getTagByTid(Integer tid) {
        return tagRepository.getTagByTid(tid);
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer tid) {
        tagRepository.deleteById(tid);
    }
}
