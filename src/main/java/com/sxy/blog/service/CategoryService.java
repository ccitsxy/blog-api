package com.sxy.blog.service;

import com.sxy.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    Category getCategoryByCid(Integer cid);

    void saveCategory(Category category);
}
