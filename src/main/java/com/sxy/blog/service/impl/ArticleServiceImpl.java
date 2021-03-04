package com.sxy.blog.service.impl;

import com.sxy.blog.entity.Article;
import com.sxy.blog.repository.ArticleRepository;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article getArticleByAid(Integer aid) {
        return articleRepository.getArticleByAid(aid);
    }

    @Override
    public void saveArticle(Article article){
        articleRepository.save(article);
    }

}
