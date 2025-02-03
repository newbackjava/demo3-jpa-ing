package com.example.demo.controller;

import com.example.demo.dto.NaverDto;
import com.example.demo.entity.Naver;
import com.example.demo.service.NaverService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("naver")
public class NaverController {

    private final NaverService naverService;

    @GetMapping("login")
    public String login() {
        return "naver/login";
    }

    @GetMapping("signUp")
    public String singUp(NaverDto naverDto, Model model) {
        //이미지 포함.
        System.out.println("naverDto = " + naverDto);
        //db처리하기 위해서 vo(entity)로 변경해주어야 함.
        Naver naver = Naver.builder()
                .email(naverDto.getEmail())
                .password(naverDto.getPassword())
                .gender(naverDto.getGender())
                .nickname(naverDto.getNickname())
                .build();
        System.out.println("naver = " + naver);

        naverService.insert(naver);
        model.addAttribute("naverDto", naverDto);
        return "naver/signUp";
    }

}
