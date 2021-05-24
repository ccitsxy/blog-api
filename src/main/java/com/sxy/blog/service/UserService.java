package com.sxy.blog.service;

import com.sxy.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User getUserByUid(Long uid);

    User getUserByUsername(String username);

    void saveUser(User user);

    void deleteUser(Long uid);

    String login(String username, String password);
}
