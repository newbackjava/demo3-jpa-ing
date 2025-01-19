package com.example.demo.controller;

import com.example.demo.entity.Young;
import com.example.demo.service.YoungService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/young")
@RequiredArgsConstructor
public class YoungController {

    private final YoungService youngService;

    @GetMapping("/young")
    public String young(){
        return "young/young";
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insert(){
        System.out.println("insert young");
        youngService.insert();
        return "ok";
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Young>> all(){
        System.out.println("all young");
        List<Young> list = youngService.findAll();
        return ResponseEntity.ok(list);
    }
}