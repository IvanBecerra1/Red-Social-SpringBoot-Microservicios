package com.example.post_service.controller;

import com.example.post_service.model.Post;
import com.example.post_service.service.IPostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final IPostService postService;

    @Value("${server.port}")
    private int serverPort;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{user_id}")
    public List<Post> getPosts(@PathVariable("user_id") Long user_id) {

        System.out.println("-------------------- Getting posts for port: " + this.serverPort);

        return this.postService.getPostsByUser(user_id);
    }
}
