package com.sxy.blog;

import com.sxy.blog.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TimeZone;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void contextLoads() {
        String[] ids = TimeZone.getAvailableIDs();
        for (String id:ids)
            System.out.printf(id+", ");
    }

}
