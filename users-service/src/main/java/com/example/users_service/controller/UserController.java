package com.example.users_service.controller;

import com.example.users_service.dto.PostDTO;
import com.example.users_service.dto.UserPostDTO;
import com.example.users_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/posts/{user_id}")
    public UserPostDTO getPosts(@PathVariable("user_id") Long user_id){
        return this.userService.getUserAndPosts(user_id);
    }


}
