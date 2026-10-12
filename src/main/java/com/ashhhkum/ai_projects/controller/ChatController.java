package com.ashhhkum.ai_projects.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
    private ChatClient openAIChatClient;
    public ChatController(ChatClient.Builder builder){
        this.openAIChatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value="q", required = true) String query){
        var resultResponse = openAIChatClient.prompt(query).call().content();
        return ResponseEntity.ok(resultResponse);

    }


}
