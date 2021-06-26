package com.sxy.blog.controller;

import com.sxy.blog.entity.Article;
import com.sxy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * GET /article : 查询所有文章
     *
     * @return 文章列表
     */
    @GetMapping
    public List<Article> findAllArticles() {
        return articleService.findAll();
    }

    /**
     * GET /article/{page}/{size} : 查询所有文章并分页
     *
     * @param page 页号 (required)
     * @param size 分页大小 (required)
     * @return 文章列表 (分页)
     */
    @GetMapping("/{page}/{size}")
    public Page<Article> findAllArticles(@PathVariable("page") Integer page,
                                                         @PathVariable("size") Integer size) {
        return articleService.findAll(page - 1, size);
    }

    /**
     * GET /article/category/{cid}/{page}/{size} : 按分类查询所有文章并分页
     *
     * @param cid  分类id (required)
     * @param page 页号 (required)
     * @param size 分页大小 (required)
     * @return 文章列表 (分页)
     */
    @GetMapping("/category/{cid}/{page}/{size}")
    public Page<Article> findArticlesByCategory(@PathVariable("cid") Integer cid,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("size") Integer size) {
        return articleService.findAllByCategory(cid, page - 1, size);
    }

    /**
     * GET /article/tag/{tid}/{page}/{size} : 按标签查询所有文章并分页
     *
     * @param tid  标签id (required)
     * @param page 页号 (required)
     * @param size 分页大小 (required)
     * @return 文章列表 (分页)
     */
    @GetMapping("/tag/{tid}/{page}/{size}")
    public Page<Article> findAllByTag(@PathVariable("tid") Integer tid,
                                      @PathVariable("page") Integer page,
                                      @PathVariable("size") Integer size) {
        return articleService.findAllByTag(tid, page - 1, size);
    }

    /**
     * GET /article/archive/{year}/{month}/{page}/{size} : 按归档查询所有文章并分页
     *
     * @param year  年 (required)
     * @param month 月 (required)
     * @param page  页号 (required)
     * @param size  分页大小 (required)
     * @return 文章列表 (分页)
     */
    @GetMapping("/archive/{year}/{month}/{page}/{size}")
    public Page<Article> findAllByArchive(@PathVariable("year") Integer year,
                                          @PathVariable("month") Integer month,
                                          @PathVariable("page") Integer page,
                                          @PathVariable("size") Integer size) {
        return articleService.findAllByArchive(year, month, page - 1, size);
    }

    /**
     * GET /article/{aid} : 按id查询文章
     *
     * @param aid 文章id (required)
     * @return 文章
     */
    @GetMapping("/{aid}")
    public Article getArticleByAid(@PathVariable Integer aid) {
        return articleService.getArticleByAid(aid);
    }

    /**
     * GET /article/archive : 查询所有归档
     *
     * @return 归档列表
     */
    @GetMapping("/archive")
    public Object findAllArchives() {
        return articleService.findAllArchives();
    }

    /**
     * POST /article : 新建或修改文章
     *
     * @param article 文章
     */
    @PostMapping
    public void createOrUpdateArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
    }

    /**
     * DELETE /article/{aid} : 删除文章
     *
     * @param aid 文章ID
     */
    @DeleteMapping("/{aid}")
    public void deleteArticle(@PathVariable Integer aid){
        articleService.deleteArticle(aid);
    }
}
