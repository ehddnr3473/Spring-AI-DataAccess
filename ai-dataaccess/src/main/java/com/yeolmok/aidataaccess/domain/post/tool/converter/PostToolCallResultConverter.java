package com.yeolmok.aidataaccess.domain.post.tool.converter;

import com.yeolmok.aidataaccess.domain.post.entity.Post;
import org.springframework.ai.tool.execution.ToolCallResultConverter;

import java.lang.reflect.Type;
import java.util.List;

public class PostToolCallResultConverter implements ToolCallResultConverter {

    @Override
    public String convert(Object result, Type returnType) {
        if (!(result instanceof List<?> posts)) {
            return "결과를 처리할 수 없습니다.";
        }

        if (posts.isEmpty()) {
            return "게시글이 없습니다.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("총 ").append(posts.size()).append("개의 게시글이 있습니다:\n\n");

        for (Object obj : posts) {
            if (obj instanceof Post post) {
                sb.append("- ID: ").append(post.getId())
                        .append("\n  제목: ").append(post.getTitle())
                        .append("\n  내용: ").append(post.getContent() != null ? post.getContent() : "(내용 없음)")
                        .append("\n  작성일: ").append(post.getCreatedAt())
                        .append("\n\n");
            }
        }

        return sb.toString();
    }
}
