package com.ashhhkum.ai_projects.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
    private final ChatClient openAIChatClient;
    private final ChatClient ollamaChatClient;

    public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
        this.openAIChatClient = ChatClient.create(openAiChatModel);
        this.ollamaChatClient = ChatClient.create(ollamaChatModel);
    }

    @GetMapping("/chat/openai")
    public ResponseEntity<String> chat(
            @RequestParam("q") String query) {
        var resultResponse = openAIChatClient.prompt(query).call().content();
        return ResponseEntity.ok(resultResponse);
    }

    @GetMapping("/chat/ollama")
    public ResponseEntity<String> ollamaChat(@RequestParam("q") String query) {
        var resultResponse = ollamaChatClient.prompt(query).call().content();
        return ResponseEntity.ok(resultResponse);
    }
}
