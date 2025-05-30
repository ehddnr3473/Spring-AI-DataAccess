package com.yeolmok.aidataaccess.domain.user.service;

import java.util.List;
import java.util.Optional;

import com.yeolmok.aidataaccess.domain.user.entity.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    List<User> findByName(String name);
    User save(User user);
    void deleteById(Long id);
}
