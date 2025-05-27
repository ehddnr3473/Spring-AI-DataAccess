package com.yeolmok.aidataaccess.domain.post.repository;

import com.yeolmok.aidataaccess.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
