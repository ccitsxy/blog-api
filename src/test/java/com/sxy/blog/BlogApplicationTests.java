package com.sxy.blog;

<<<<<<< HEAD
import com.sxy.blog.repository.CategoryRepository;
=======
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxy.blog.constant.JsonPage;
import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Tag;
import com.sxy.blog.repository.ArticleRepository;
import com.sxy.blog.repository.CommentRepository;
>>>>>>> parent of 6b2c24c (delete comment)
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

}
