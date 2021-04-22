package com.sxy.blog;

import com.sxy.blog.repository.ArticleRepository;
import com.sxy.blog.util.PasswordUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void contextLoads() {
        String en = PasswordUtil.Encrypt("admin");
        System.out.println(en);
    }

}
