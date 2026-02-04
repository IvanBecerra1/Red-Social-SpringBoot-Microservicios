package com.example.users_service.service;

import com.example.users_service.dto.PostDTO;
import com.example.users_service.dto.UserPostDTO;
import com.example.users_service.model.User;
import com.example.users_service.repository.IPostRepository;
import com.example.users_service.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IPostRepository postRepository;

    public UserServiceImpl(IUserRepository userRepository, IPostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;

    }

    @Override
    public UserPostDTO getUserAndPosts(Long user_id) {
        User userFind = this.userRepository.findById(user_id).orElse(null);

        // Get data in endpoint Microservices Post
        List<PostDTO> postFindList =this.postRepository.getPosts(user_id);

        return new UserPostDTO(userFind.getName(),
                userFind.getLastname(), userFind.getCellphone(), postFindList);
    }
}
