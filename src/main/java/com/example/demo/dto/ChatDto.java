package com.example.demo.dto;

import com.example.demo.entity.Chat;
import groovy.transform.builder.Builder;
import lombok.Value;

import java.io.Serializable;

@Value //생성자, private final, getter
@Builder
public class ChatDto{
    long messageId;
    String message;
    String loginId;
}