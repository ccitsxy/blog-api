package com.sxy.blog.repository;

import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Category;
import com.sxy.blog.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
    // 根据ID查询文章
    Article getArticleByAid(Long aid);

    // 根据分类查询文章
    Page<Article> findArticlesByCategory(Category category, Pageable pageable);

    // 查询归档
    @Query(value = "select function('year', a.created) as year, function('month', a.created) as month" +
            " from Article a group by year,month order by a.aid desc")
    List<Map<String, Object>> archiveArticles();

    // 查询所有归档并查询对应文章数
    @Query(value = "select function('year', a.created) as year, function('month', a.created) as month," +
            "count (a) as count from Article a group by year,month order by a.aid desc")
    List<Map<String, Object>> archiveArticlesAndCount();

    // 查询时间段内的文章
    Page<Article> findArticlesByCreatedBetween(LocalDateTime created, LocalDateTime created2, Pageable pageable);
}