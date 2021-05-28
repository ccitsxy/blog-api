package com.sxy.blog.controller;

import com.sxy.blog.entity.Comment;
import com.sxy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * GET /comment/article/{aid}/{page}/{size} : 按文章ID查询所有评论并分页
     *
     * @param aid  文章ID (required)
     * @param page  页号 (required)
     * @param size  分页大小 (required)
     * @return 评论列表 (分页)
     */
    @GetMapping("/article/{aid}/{page}/{size}")
    public Page<Comment> findAllCommentsByAid(@PathVariable("aid") Integer aid,
                                              @PathVariable("page") Integer page,
                                              @PathVariable("size") Integer size) {
        return commentService.findAllByArticle(aid, page - 1, size);
    }
}
