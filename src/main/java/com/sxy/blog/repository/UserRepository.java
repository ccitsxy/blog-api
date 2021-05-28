package com.sxy.blog.repository;

import com.sxy.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 根据ID查询用户
    User getUserByUid(Integer uid);

    // 根据用户名查询用户
    User getUserByUsername(String username);
}
