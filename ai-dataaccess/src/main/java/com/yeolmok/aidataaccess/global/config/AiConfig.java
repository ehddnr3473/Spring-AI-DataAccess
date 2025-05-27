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
                        If there's no data, tell me there isn't.
                       """)
                .defaultTools(readOnlyTool, userTool, postTool)
                .build();
    }
}
