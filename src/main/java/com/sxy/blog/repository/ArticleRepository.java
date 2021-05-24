package com.sxy.blog.repository;

import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {
    Article getArticleByAid(Integer aid);

    Page<Article> findArticlesByCategory(Category category, Pageable pageable);

    @Query(value = "select function('year', a.created) as year, function('month', a.created) as month" +
            " from Article a group by year,month order by a.aid desc")
    List<Map<String, Object>> archiveArticles();

    @Query(value = "select function('year', a.created) as year, function('month', a.created) as month," +
            "count (a) as count from Article a group by year,month order by a.aid desc")
    List<Map<String, Object>> archiveArticlesAndCount();

    Page<Article> findArticlesByCreatedBetween(LocalDateTime created, LocalDateTime created2, Pageable pageable);
}