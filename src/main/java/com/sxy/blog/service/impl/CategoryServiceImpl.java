package com.sxy.blog.service.impl;

import com.sxy.blog.entity.Category;
import com.sxy.blog.repository.CategoryRepository;
import com.sxy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getCategoryByCid(Integer cid) {
        return categoryRepository.getCategoryByCid(cid);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
