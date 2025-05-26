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
}
