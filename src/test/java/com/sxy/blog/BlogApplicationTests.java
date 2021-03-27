package com.sxy.blog;

import com.sxy.blog.repository.UserRepository;
import com.sxy.blog.service.UserService;
import com.sxy.blog.util.PasswordUtil;
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
        String en = PasswordUtil.Encrypt("123456");
        System.out.println(en);
        Boolean de = PasswordUtil.Decrypt("123456", en);
        System.out.println(de);
    }

}
