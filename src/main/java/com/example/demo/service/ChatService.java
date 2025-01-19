package com.example.demo.service;

import com.example.demo.entity.Chat;
import com.example.demo.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Value
@Service
@RequiredArgsConstructor
public class ChatService {

    ChatRepository chatRepository;

    public Chat saveMessage(Chat message) {
        return chatRepository.save(message);
    }
}
