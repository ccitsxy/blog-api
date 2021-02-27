package com.sxy.blog.service;

import com.sxy.blog.entity.User;
import com.sxy.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("user/all")
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
