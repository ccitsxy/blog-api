package com.sxy.blog;

import com.sxy.blog.util.PasswordUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("PasswordUtil.Encrypt(\"admin\") = " + PasswordUtil.Encrypt("admin"));
        System.out.println("PasswordUtil.Decrypt(\"admin\",\"$2a$10$1IO6SRybWwfDtA.dJFGiAeknOBtRY7ckua.U3lz7wt9bJLUWZMiBy\") = " + PasswordUtil.Decrypt("admin", "$2a$10$1IO6SRybWwfDtA.dJFGiAeknOBtRY7ckua.U3lz7wt9bJLUWZMiBy"));
    }

}
