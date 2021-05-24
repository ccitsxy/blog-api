package com.sxy.blog.service;

import com.sxy.blog.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Page<Article> findAll(Integer page, Integer size);

    Page<Article> findAllByCategory(Long cid, Integer page, Integer size);

    Page<Article> findAllByTag(Long tid, Integer page, Integer size);

    Page<Article> findAllByArchive(Integer year, Integer month, Integer page, Integer size);

    List<Article> findAll();

    Article getArticleByAid(Long aid);

    List<Map<String, Object>> archiveAll();

    void saveArticle(Article article);
}
