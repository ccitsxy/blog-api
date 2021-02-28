package com.sxy.blog.controller;

import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public Page<Article> findAll(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("size") Integer size) {
        return articleService.findAll(PageRequest.of(pageNum, size));
    }

    @PostMapping("/")
    public void saveArticle(@RequestParam("title") String title,
                            @RequestParam("markdown") String Markdown,
                            @RequestParam("html") String html) {
        Article article = new Article();
        article.setTitle("");
        article.setMarkdown("");
        article.setHtml("");
    }
}
