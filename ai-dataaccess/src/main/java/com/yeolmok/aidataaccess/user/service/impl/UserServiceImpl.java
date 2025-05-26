package com.yeolmok.aidataaccess.user.service.impl;

import java.util.List;
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
}
