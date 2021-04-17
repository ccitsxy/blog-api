package com.sxy.blog.service;

import com.sxy.blog.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {
    Page<Article> findAll(Integer page, Integer size);

    Page<Article> findAllByCategory(Integer cid,Integer page, Integer size);

    Page<Article> findAllByTag(Integer tid,Integer page, Integer size);

    List<Article> findAll();

    Article getArticleByAid(Integer aid);

    void saveArticle(Article article);
}
