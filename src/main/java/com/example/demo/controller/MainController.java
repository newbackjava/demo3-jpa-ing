package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("404")
    public String code404() {
        return "404";
    }

    @RequestMapping("live")
    public String live() {
        return "live";
    }

    @RequestMapping("product")
    public String product() {
        return "product";
    }

    @RequestMapping("features")
    public String features() {
        return "features";
    }

    @RequestMapping("blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("blog-details")
    public String blog_details() {
        return "blog-details";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact-us";
    }


}
