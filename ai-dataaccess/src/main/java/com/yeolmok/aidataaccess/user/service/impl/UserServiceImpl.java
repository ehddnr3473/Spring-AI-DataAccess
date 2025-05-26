package com.yeolmok.aidataaccess.user.service.impl;

import java.util.List;
import java.util.Optional;

import com.yeolmok.aidataaccess.user.entity.User;
import com.yeolmok.aidataaccess.user.repository.UserRepository;
import com.yeolmok.aidataaccess.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
