package com.sxy.blog.service;

import com.sxy.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User getUserByUid(Integer uid);

    User getUserByUsername(String username);

    void saveUser(User user);

    void deleteUser(Integer uid);

    String login(String username, String password);
}
