package com.sxy.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.sxy.blog.entity.User;
import com.sxy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{page}/{size}")
    public Page<User> findAllUsers(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return userService.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    public void createOrUpdateUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable Integer uid) {
        userService.deleteUser(uid);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("/logout")
    public void logout() {
        StpUtil.logout();
    }

    /**
     * POST /user/register : 注册用户
     *
     * @param user 用户
     */
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.saveUser(user);
    }
}
