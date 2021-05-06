package com.sxy.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @JsonView(Article.ArticleInfo.class)
    @GetMapping
    public List<Article> findAllArticles() {
        return articleService.findAll();
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/{page}/{size}")
    public Page<Article> findAllArticles(@PathVariable("page") Integer page,
                                         @PathVariable("size") Integer size) {
        return articleService.findAll(page - 1, size);
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/category/{cid}/{page}/{size}")
    public Page<Article> findArticlesByCategory(@PathVariable("cid") Integer cid,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("size") Integer size) {
        return articleService.findAllByCategory(cid, page - 1, size);
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/tag/{tid}/{page}/{size}")
    public Page<Article> findAllByTag(@PathVariable("tid") Integer tid,
                                      @PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size) {
        return articleService.findAllByTag(tid, page - 1, size);
    }

    @JsonView(Article.ArticleInfo.class)
    @GetMapping("/archive/{year}/{month}/{page}/{size}")
    public Page<Article> findAllByArchive(@PathVariable("year") Integer year,
                                          @PathVariable Integer month,
                                          @PathVariable("page") Integer page,
                                          @PathVariable("size") Integer size) {
        return articleService.findAllByArchive(year, month, page - 1, size);
    }

    @GetMapping("/{aid}")
    public Article getArticleByAid(@PathVariable Integer aid) {
        return articleService.getArticleByAid(aid);
    }

    @GetMapping("/archive")
    public Object archiveArticles() {
        return articleService.archiveArticles();
    }

    @PostMapping
    public void createOrUpdateArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
    }
}
