package com.yeolmok.aidataaccess.domain.user.repository;

import com.yeolmok.aidataaccess.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
