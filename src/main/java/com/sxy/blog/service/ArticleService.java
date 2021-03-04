package com.sxy.blog.service;

import com.sxy.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
    Page<Article> findAll(Pageable pageable);

    Article getArticleByAid(Integer aid);

    void saveArticle(Article article);
}
