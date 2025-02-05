package com.example.demo.controller;

import com.example.demo.entity.Bbs2;
import com.example.demo.service.Bbs2Service;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@Controller
//@RestController
//각 메서드마다 @ResponseBody가 필요없다.
//모든 컨트롤러의 응답이 json등의 데이터로 리턴하는 경우만 가능!
@RequestMapping("bbs")
@RequiredArgsConstructor
//@Value --> 멤버변수가 final이 된다.!
public class BbsController {

    private final Bbs2Service bbs2Service;

    //Bbs첫페이지
    @GetMapping("bbs")
   // @ResponseBody
    public String getBbs(Model model) {
        return "bbs/bbs";
    }

    @GetMapping("list") // /bbs/list?page=1
    public String getBbsList(@RequestParam(defaultValue = "0") int page,
                             Model model) {
        //1.페이지 계산할 수 있는 객체 생성(Pageable객체)
        Pageable pageable = PageRequest.of(page, 10);
        //2.1번을 전달해서 검색후 결과를 받아오자.(Page객체)
        Page<Bbs2> pageInfo = bbs2Service.findAll(pageable);
        System.out.println("====================================");
        System.out.println(pageInfo);
        System.out.println("====================================");
        //3.model속성으로 지정해서 template으로 넘기자.(Page객체)
        model.addAttribute("pageInfo", pageInfo);
        return "bbs/list";
    }
}
