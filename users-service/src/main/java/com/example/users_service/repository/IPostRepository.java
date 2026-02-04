package com.example.users_service.repository;


import com.example.users_service.dto.PostDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "post-service")
public interface IPostRepository {

    @GetMapping("/posts/{user_id}")
    public List<PostDTO> getPosts(@PathVariable("user_id") Long user_id);
}
