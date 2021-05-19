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

    @GetMapping("/{aid}/{page}/{size}")
    public Page<Comment> findAllCommentsByAid(@PathVariable("aid") Integer aid,
                                              @PathVariable("page") Integer page,
                                              @PathVariable("size") Integer size) {
        return commentService.findAllByArticle(aid, page - 1, size);
    }
}
