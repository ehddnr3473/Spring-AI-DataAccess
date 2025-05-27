package com.yeolmok.aidataaccess.global.config;

import jakarta.annotation.Nullable;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class ReadOnlyTool {

    @Tool(description = "Rejects write operations such as insert, update, or delete")
    public String rejectWriteOperations(@Nullable String action) {
        return (action != null ? action : "해당") + " 작업은 허용되지 않습니다. 시스템은 읽기 전용 모드입니다.";
    }
}
