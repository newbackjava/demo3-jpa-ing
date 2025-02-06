package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ReplyMemberDto {
    private Long replyNo;
    private String memberId;
    private String name; //member
    private String content; //reply
}
