package com.sxy.blog.service.impl;

import com.sxy.blog.constant.JsonPage;
import com.sxy.blog.entity.Category;
import com.sxy.blog.repository.CategoryRepository;
import com.sxy.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Category> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("cid"));
        PageRequest pr = PageRequest.of(page, size, sort);
        return new JsonPage<>(categoryRepository.findAll(pr), pr);
    }

    @Override
    public Category getCategoryByCid(Integer cid) {
        return categoryRepository.getCategoryByCid(cid);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }
}
