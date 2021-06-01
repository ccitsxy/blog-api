package com.sxy.blog.service.impl;

import com.sxy.blog.constant.JsonPage;
import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Category;
import com.sxy.blog.entity.Tag;
import com.sxy.blog.repository.ArticleRepository;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(articleRepository.findAll(pr), pr);
    }

    @Override
    public Page<Article> findAllByCategory(Integer cid, Integer page, Integer size) {
        Category category = new Category();
        category.setCid(cid);
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(articleRepository.findArticlesByCategory(category, pr), pr);
    }

    @Override
    public Page<Article> findAllByTag(Integer tid, Integer page, Integer size) {
        Specification<Article> spec = (root, cq, cb) -> {
            Join<Article, Tag> join = root.join("tags", JoinType.LEFT);
            return cb.equal(join.get("tid"), tid);
        };
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(articleRepository.findAll(spec, pr), pr);
    }

    @Override
    public Page<Article> findAllByArchive(Integer year, Integer month, Integer page, Integer size) {
        LocalDateTime ldt = LocalDateTime.of(year,month,1,0,0,0);
        LocalDateTime ldt2 = LocalDateTime.of(year,month+1,1,0,0,0);
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(articleRepository.findArticlesByCreatedBetween(ldt, ldt2, pr), pr);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleByAid(Integer aid) {
        return articleRepository.getArticleByAid(aid);
    }

    @Override
    public List<Map<String, Object>> findAllArchives() {
        return articleRepository.archiveArticles();
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer aid) {
        articleRepository.deleteById(aid);
    }
}
