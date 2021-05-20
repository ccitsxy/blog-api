package com.sxy.blog;

import com.sxy.blog.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void contextLoads() {
/*        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(commentRepository.findAllByParentIsNull()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }

}
