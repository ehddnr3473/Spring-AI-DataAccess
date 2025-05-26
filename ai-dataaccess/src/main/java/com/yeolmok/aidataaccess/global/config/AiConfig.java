package com.yeolmok.aidataaccess.global.config;

import com.yeolmok.aidataaccess.domain.user.tool.UserTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(OllamaChatModel chatModel, UserTool userTool) {
        return ChatClient.builder(chatModel)
                .defaultTools(userTool)
                .build();
    }
}
