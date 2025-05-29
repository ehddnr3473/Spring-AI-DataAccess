package com.yeolmok.aidataaccess.domain.user.tool.converter;

import com.yeolmok.aidataaccess.domain.user.entity.User;
import org.springframework.ai.tool.execution.ToolCallResultConverter;

import java.lang.reflect.Type;

public class UserToolCallResultConverter implements ToolCallResultConverter {

    @Override
    public String convert(Object result, Type returnType) {
        if (result instanceof User user) {
            return String.format("사용자 이름은 %s이고, 이메일은 %s입니다.", user.getName(), user.getEmail());
        }
        return "";
    }
}
