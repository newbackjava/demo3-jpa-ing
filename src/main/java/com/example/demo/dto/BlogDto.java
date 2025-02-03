package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogDto implements Serializable {
    //
//    Long blogId;
    String name;
    String mail;
    String img;
    String content;
}
