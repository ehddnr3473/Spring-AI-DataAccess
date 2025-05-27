package com.yeolmok.aidataaccess.global.config;

import com.yeolmok.aidataaccess.domain.post.tool.PostTool;
import com.yeolmok.aidataaccess.domain.user.tool.UserTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(OllamaChatModel chatModel,
                                 ReadOnlyTool readOnlyTool,
                                 UserTool userTool,
                                 PostTool postTool) {
        return ChatClient.builder(chatModel)
                .defaultSystem("""
                        You are a read-only assistant.
                        Never perform insert, update, or delete actions.
                        If such requests occur, respond using the read-only tool.
                        When calling rejectWriteOperations, always return the tool's result directly as your response to the user.
                        If there's no data, tell me there isn't.
                       
                        Examples:
                        - User: 새로운 유저를 추가해줘
                          Assistant: (call rejectWriteOperations("생성"))
                       
                        - User: 이름이 바뀌었어. 수정해줘.
                          Assistant: (call rejectWriteOperations("수정"))
                       
                       - User: 게시글을 삭제해줘
                         Assistant: (call rejectWriteOperations("삭제"))
                       
                       - User: 모든 유저 정보를 보여줘
                         Assistant: (call getAllUsers())
                       
                       - User: 유저 ID가 1인 사람의 정보를 알려줘
                         Assistant: (call getUserById(1))
                       """)
                .defaultTools(readOnlyTool, userTool, postTool)
                .build();
    }
}
