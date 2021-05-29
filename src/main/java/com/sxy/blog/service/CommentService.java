package com.sxy.blog.service;

import com.sxy.blog.entity.Comment;
import org.springframework.data.domain.Page;

public interface CommentService {
    Page<Comment> findAllByArticle(Integer aid,Integer page,Integer size);

    void deleteComment(Integer coid);
}
