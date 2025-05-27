package com.yeolmok.aidataaccess.domain.post.service.impl;

import com.yeolmok.aidataaccess.domain.post.entity.Post;
import com.yeolmok.aidataaccess.domain.post.repository.PostRepository;
import com.yeolmok.aidataaccess.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findByName(String title) {
        return postRepository.findByTitle(title);
    }
}
