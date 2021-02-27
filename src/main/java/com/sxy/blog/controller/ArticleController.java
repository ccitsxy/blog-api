package com.sxy.blog.controller;

import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/findAll")
    public Page<Article> findAll(@RequestParam("pageNum") int pageNum, @RequestParam("size") int size) {
        return articleService.findAll(PageRequest.of(pageNum, size));
    }
}
