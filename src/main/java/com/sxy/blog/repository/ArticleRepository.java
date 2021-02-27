package com.sxy.blog.repository;

import com.sxy.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article getArticleByAid(Integer aid);
}