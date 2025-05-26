package com.yeolmok.aidataaccess.user.repository;

import com.yeolmok.aidataaccess.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    List<User> findAllByName(String name);
}
