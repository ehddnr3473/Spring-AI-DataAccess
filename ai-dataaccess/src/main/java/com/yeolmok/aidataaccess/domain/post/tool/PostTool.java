package com.yeolmok.aidataaccess.domain.post.tool;

import com.yeolmok.aidataaccess.domain.post.entity.Post;
import com.yeolmok.aidataaccess.domain.post.service.PostService;
import com.yeolmok.aidataaccess.domain.post.tool.converter.PostToolCallResultConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostTool {

    private final PostService postService;

    @Tool(description = "Get all posts", returnDirect = true, resultConverter = PostToolCallResultConverter.class)
    public List<Post> getAllPosts() {
        return postService.findAll();
    }
}
