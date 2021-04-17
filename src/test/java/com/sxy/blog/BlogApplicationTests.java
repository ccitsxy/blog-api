package com.sxy.blog;

import com.sxy.blog.entity.Article;
import com.sxy.blog.entity.Tag;
import com.sxy.blog.repository.ArticleRepository;
import com.sxy.blog.repository.UserRepository;
import com.sxy.blog.service.ArticleService;
import com.sxy.blog.service.UserService;
import com.sxy.blog.util.PasswordUtil;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
class BlogApplicationTests {

    /*    @Autowired
        UserRepository userRepository;

        @Autowired
        UserService userService;*/
/*    @Autowired
    ArticleService articleService;*/
    @Autowired
    ArticleRepository articleRepository;

    @Test
    void contextLoads() {
/*        Article article = new Article();
        Tag tag1 = new Tag();
        tag1.setTid(1);
        Set<Tag> tags= new LinkedHashSet<>();
        tags.add(tag1);
        article.setTags(tags);
        articleService.saveArticle(article);
        System.out.println(article);*/
/*        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        userRepository.save(user);*/
/*        StpUtil.setLoginId(1);
        System.out.println(StpUtil.getTokenInfo());*/
/*        // 生成密码
        String bcryptHashString = BCrypt.withDefaults().hashToString(10, "123456".toCharArray());
        System.out.println(bcryptHashString);

        // 校验密码
        BCrypt.Result result = BCrypt.verifyer().verify("123456".toCharArray(), bcryptHashString);
        System.out.println(result.verified);*/
/*        String en = PasswordUtil.Encrypt("123456");
        System.out.println(en);
        Boolean de = PasswordUtil.Decrypt("123456", en);
        System.out.println(de);*/

    }

}
