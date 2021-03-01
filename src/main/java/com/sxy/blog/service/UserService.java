package com.sxy.blog.service;

import com.sxy.blog.entity.User;
import com.sxy.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getUserByUid(Integer uid) {
        return userRepository.getUserByUid(uid);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer uid){
        userRepository.deleteById(uid);
    }
}
