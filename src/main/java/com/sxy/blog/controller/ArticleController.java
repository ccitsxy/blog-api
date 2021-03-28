package com.sxy.blog.controller;

import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/{page}/{size}")
    public Page<Article> findAllArticles(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        return articleService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{aid}")
    public Article getArticleByAid(@PathVariable Integer aid){
        return articleService.getArticleByAid(aid);
    }

    @PostMapping 
    public void createArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
    }

    @PutMapping
    public void updateArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
    }
}
