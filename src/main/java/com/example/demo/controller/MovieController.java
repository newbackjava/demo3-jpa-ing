package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movie")
public class MovieController {

    @GetMapping("insert")
    public String insert() {
        return "insert";
    }

    @GetMapping("all")
    public String all() {
        return "all";
    }
}
