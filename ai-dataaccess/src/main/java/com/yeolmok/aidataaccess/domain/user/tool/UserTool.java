package com.yeolmok.aidataaccess.domain.user.tool;

import com.yeolmok.aidataaccess.domain.user.tool.converter.UserToolCallResultConverter;
import com.yeolmok.aidataaccess.domain.user.entity.User;
import com.yeolmok.aidataaccess.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserTool {

    private final UserService userService;

    @Tool(description = "Get all users", returnDirect = true)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Tool(description = "Get a user by their id", returnDirect = true, resultConverter = UserToolCallResultConverter.class)
    public User getUserById(Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 ID의 유저가 없습니다."));
    }

    @Tool(description = "Get user by name", returnDirect = true)
    public List<User> getUserByName(String name) {
        List<User> users = userService.findByName(name);

        if (users.isEmpty()) {
            throw new NoSuchElementException("해당 이름의 유저가 존재하지 않습니다.");
        }

        return users;
    }
}