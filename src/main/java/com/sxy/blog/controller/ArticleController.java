package com.sxy.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/{page}/{size}")
    public Page<Article> findAllArticles(@PathVariable("page") Integer page,
                                         @PathVariable("size") Integer size) {
        return articleService.findAll(page, size);
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/category/{cid}/{page}/{size}")
    public Page<Article> findArticlesByCategory(@PathVariable("cid") Integer cid,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("size") Integer size) {
        return articleService.findAllByCategory(cid, page, size);
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/tag/{tid}/{page}/{size}")
    public Page<Article> findAllByTag(@PathVariable("tid") Integer tid,
                                      @PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size) {
        return articleService.findAllByTag(tid, page, size);
    }

    @GetMapping("/{aid}")
    public Article getArticleByAid(@PathVariable Integer aid) {
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
