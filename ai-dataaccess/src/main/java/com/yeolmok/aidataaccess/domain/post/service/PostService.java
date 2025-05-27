package com.yeolmok.aidataaccess.domain.post.service;

import java.util.List;
import java.util.Optional;

import com.yeolmok.aidataaccess.domain.post.entity.Post;

public interface PostService {

    List<Post> findAll();
    Optional<Post> findById(Long id);
    List<Post> findByName(String name);
}
