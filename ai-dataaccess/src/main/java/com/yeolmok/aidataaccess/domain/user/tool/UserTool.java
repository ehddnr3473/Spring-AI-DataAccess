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

    @Tool(description = "Get all users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Tool(description = "Get user by id")
    public User getUserById(Long id) {
        return userService.findById(id)
                .orElse(null);
    }

    @Tool(description = "Get user by name")
    public List<User> getUserByName(String name) {
        return userService.findByName(name);
    }

    @Tool(description = "This tool blocks write actions such as insert, update, or delete.")
    public String denyWriteOperations(String action) {
        return action + " 작업은 허용되지 않습니다. 이 시스템은 읽기 전용 모드입니다.";
    }
}