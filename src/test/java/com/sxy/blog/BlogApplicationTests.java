package com.sxy.blog;

import com.sxy.blog.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

}
