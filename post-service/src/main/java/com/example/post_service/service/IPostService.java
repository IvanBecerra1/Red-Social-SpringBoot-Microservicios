package com.example.post_service.service;

import com.example.post_service.model.Post;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostService {

    public List<Post> getPostsByUser(Long user_id);
}
