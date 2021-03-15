package com.sxy.blog.controller;

import com.sxy.blog.entity.User;
import com.sxy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{page}/{size}")
    public Page<User> findAllUsers(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return userService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{uid}")
    public User getUserByUid(@PathVariable("uid") Integer uid) {
        return userService.getUserByUid(uid);
    }

    @PostMapping("/")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable Integer uid) {
        userService.deleteUser(uid);
    }

    @GetMapping("/login")
    public void login(){

    }
}
