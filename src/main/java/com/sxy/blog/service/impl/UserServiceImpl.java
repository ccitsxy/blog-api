package com.sxy.blog.service.impl;

import com.sxy.blog.entity.User;
import com.sxy.blog.repository.UserRepository;
import com.sxy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserByUid(Integer uid) {
        return userRepository.getUserByUid(uid);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer uid){
        userRepository.deleteById(uid);
    }
}