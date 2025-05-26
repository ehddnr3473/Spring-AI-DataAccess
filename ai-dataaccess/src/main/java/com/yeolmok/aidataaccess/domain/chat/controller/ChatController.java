package com.yeolmok.aidataaccess.domain.chat.controller;

import com.yeolmok.aidataaccess.domain.chat.dto.PromptDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatClient chatClient;

    @PostMapping
    public String chat(@RequestBody PromptDto promptDto) {
        return chatClient.prompt(promptDto.getPrompt()).call().content();
    }
}
