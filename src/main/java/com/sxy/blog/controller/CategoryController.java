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

    @JsonView(Category.CategoryInfo.class)
    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @JsonView(Category.CategoryDetail.class)
    @GetMapping("/{page}/{size}")
    public Page<Category> findAllCategories(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return categoryService.findAll(page, size);
    }

    @GetMapping("/{cid}")
    public Category findCategoryByCid(@PathVariable Integer cid) {
        return categoryService.getCategoryByCid(cid);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
}
