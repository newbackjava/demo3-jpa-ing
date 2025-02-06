package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Builder
@Data
@AllArgsConstructor
public class BbsReplyDto {
    private Long bbsNo;
    private Long replyNo;
    private String title;
    private String content; //reply
}
