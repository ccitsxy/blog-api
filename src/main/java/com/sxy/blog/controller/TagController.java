package com.sxy.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.entity.Tag;
import com.sxy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @JsonView(Tag.TagInfo.class)
    @GetMapping
    public List<Tag> findAllTags() {
        return tagService.findAll();
    }

    @JsonView(Tag.TagDetail.class)
    @GetMapping("/{page}/{size}")
    public Page<Tag> findAllTags(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return tagService.findAll(page - 1, size);
    }

    @GetMapping("/{tid}")
    public Tag findTagByTid(@PathVariable Integer tid) {
        return tagService.getTagByTid(tid);
    }

    @PostMapping
    public void createOrUpdateTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
    }
}
