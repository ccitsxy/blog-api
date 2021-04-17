package com.sxy.blog.repository;

import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {
    Article getArticleByAid(Integer aid);

    Page<Article> findAllByCategory(Category category, Pageable pageable);

    Page<Article> findAll(Specification spec,Pageable pageable);
}