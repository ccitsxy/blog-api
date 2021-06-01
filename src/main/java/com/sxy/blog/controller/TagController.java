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

    /**
     * GET /tag : 查询所有标签
     *
     * @return 标签列表
     */
    @JsonView(Tag.TagInfo.class)
    @GetMapping
    public List<Tag> findAllTags() {
        return tagService.findAll();
    }

    /**
     * GET /tag/{page}/{size} : 查询所有标签并分页
     *
     * @param page 页号 (required)
     * @param size 分页大小 (required)
     * @return 标签列表 (分页)
     */
    @JsonView(Tag.TagDetail.class)
    @GetMapping("/{page}/{size}")
    public Page<Tag> findAllTags(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return tagService.findAll(page - 1, size);
    }

    /**
     * GET /tag/{tid} : 按id查询标签
     *
     * @param tid 标签id (required)
     * @return 标签
     */
    @GetMapping("/{tid}")
    public Tag findTagByTid(@PathVariable Integer tid) {
        return tagService.getTagByTid(tid);
    }

    /**
     * POST /tag : 新建或修改标签
     *
     * @param tag 标签
     */
    @PostMapping
    public void createOrUpdateTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
    }

    /**
     * DELETE /tag/{tid} : 删除标签
     *
     * @param tid 标签id (required)
     */
    @DeleteMapping("/{tid}")
    public void deleteCategory(@PathVariable Integer tid) {
        tagService.deleteTag(tid);
    }
}
