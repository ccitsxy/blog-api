package com.sxy.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping
    public void upload(@RequestBody MultipartFile multipartFile){
        
    }
}
