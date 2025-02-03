package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entity.Naver}
 */
@Value
@Data
@AllArgsConstructor
public class NaverDto implements Serializable {
    String email;
    String password;
    String nickname;
    String gender;
    String profile_image;
}