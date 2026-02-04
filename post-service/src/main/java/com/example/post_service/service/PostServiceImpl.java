package com.example.post_service.service;

import com.example.post_service.model.Post;
import com.example.post_service.repository.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;

    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> getPostsByUser(Long user_id) {
        return this.postRepository.findAllByUserId(user_id);
    }
}
