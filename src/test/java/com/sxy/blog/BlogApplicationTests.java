package com.sxy.blog;

import com.sxy.blog.entity.User;
import com.sxy.blog.repository.UserRepository;
import com.sxy.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        userRepository.save(user);
    }

}
