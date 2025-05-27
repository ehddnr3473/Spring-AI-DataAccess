package com.yeolmok.aidataaccess.domain.user.tool;

import com.yeolmok.aidataaccess.domain.user.entity.User;
import com.yeolmok.aidataaccess.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserTool {

    private final UserService userService;

    @Tool(description = "Get all users", returnDirect = true)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Tool(description = "Get a user by their id", returnDirect = true)
    public User getUserById(Long id) {
        return userService.findById(id)
                .orElse(null);
    }

    @Tool(description = "Get user by name", returnDirect = true)
    public List<User> getUserByName(String name) {
        return userService.findByName(name);
    }
}