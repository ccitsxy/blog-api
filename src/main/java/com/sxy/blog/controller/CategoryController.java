package com.sxy.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sxy.blog.entity.Category;
import com.sxy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * GET /category : 查询所有分类
     *
     * @return 分类列表
     */
    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    /**
     * GET /category/{page}/{size} : 查询所有分类并分页
     *
     * @param page 页号 (required)
     * @param size 分页大小 (required)
     * @return 标签列表 (分页)
     */
    @JsonView(Category.CategoryDetail.class)
    @GetMapping("/{page}/{size}")
    public Page<Category> findAll(@PathVariable("page") Integer page,
                                  @PathVariable("size") Integer size) {
        return categoryService.findAll(page - 1, size);
    }

    /**
     * GET /category/{cid} : 按id查询分类
     *
     * @param cid 分类id (required)
     * @return 分类
     */
    @GetMapping("/{cid}")
    public Category findCategoryByCid(@PathVariable Integer cid) {
        return categoryService.getCategoryByCid(cid);
    }

    /**
     * POST /category : 新建或修改分类
     *
     * @param category 分类
     */
    @PostMapping
    public void createOrUpdateCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    /**
     * DELETE /category/{cid} : 删除分类
     *
     * @param cid 分类id (required)
     */
    @DeleteMapping("/{cid}")
    public void deleteCategory(@PathVariable Integer cid) {
        categoryService.deleteCategory(cid);
    }
}
