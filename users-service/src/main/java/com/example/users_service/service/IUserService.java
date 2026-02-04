package com.example.users_service.service;

import com.example.users_service.dto.UserPostDTO;
import org.springframework.stereotype.Service;

public interface IUserService {

    public UserPostDTO getUserAndPosts(Long user_id);

}
