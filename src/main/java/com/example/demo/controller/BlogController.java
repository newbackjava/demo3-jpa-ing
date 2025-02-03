package com.example.demo.controller;

import com.example.demo.dto.BlogDto;
import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("blog")
public class BlogController {

    private final BlogService blogService; //주입, di

    @Value("${upload.path}")
    private String uploadPath; //yaml에 있는 값이 들어감.

    @GetMapping("blog")
    public String blog() {
        return "blog/blog";
    }

    @GetMapping("blog-details")
    public String blog_details() {
        return "blog/blog-details";
    }

    @PostMapping("blog-result")
    public String blog_result(String content, String contentId, Model model) {
        System.out.println("content: " + content);
        System.out.println("contentId: " + contentId);
        String result = blogService.trans(content);
        //번역글
        model.addAttribute("result", result);
        //누구명언
        model.addAttribute("contentId", contentId);
        return "blog/blog-result";
    }

    @PostMapping("upload")
    public String upload(BlogDto blogDto,
                         @RequestParam("file") MultipartFile file,
                         Model model) {

        System.out.println("blogDto: " + blogDto);

        try{ //파일을 다룰 때는 예외처리하자.!
            //1. 파일이 있으면 파일 원래 이름 추출하자.
            if(!file.isEmpty()){ //파일이 있으면
                String originalFilename = file.getOriginalFilename();
                //2. 파일명이 겹치면 안되므로 UUID를 이용해서 유니크한 값을 만들자.
                String uuid = UUID.randomUUID().toString();

                //3. 유니크한 값 + 파일원래이름을 붙여서
                String savedFilename = uuid + "_" + originalFilename;

                //4. 파일객체로 만들자.
                File uploadDir = new File(uploadPath); //경로인식!
                //저장할 위치를 폴더로 인식하기 위해서 파일객체로 만들었음.
                //그 폴더가 있지않으면! 그 폴더를 만들어라!
                if(!uploadDir.exists()){
                    uploadDir.mkdirs();
                }

                //5. 파일로 지정된 위치에 저장하자.
                //폴더와 파일 2개를 File객체로 만들어주자.
                File uploadFile = new File(uploadPath + "/" + savedFilename);
                //c:/~~~/파일명 인식함.
                file.transferTo(uploadFile); //upload폴더에 저장됨.

                //dto에 다른 값들은 다 들어있는데 파일이름이 빠져있음.
                blogDto.setImg(savedFilename);
                System.out.println("=========> blogDto: " + blogDto); //img까지 포함
                Blog blog = blogService.insert(blogDto);
                System.out.println("=========> db넣은 후 blog: " + blog);
                model.addAttribute("blog", blog);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "blog/upload";
    }//upload

    @GetMapping("/total")
    @ResponseBody
    public ResponseEntity<Long> getTotalCount() {
        return ResponseEntity.ok(blogService.totalCount());
    }

    @GetMapping("/up3")
    @ResponseBody
    public ResponseEntity<Long> up3() {
        return ResponseEntity.ok(blogService.up3());
    }

    @GetMapping("/happy")
    @ResponseBody
    public ResponseEntity<Integer>happy() {
        return ResponseEntity.ok(blogService.findHappy().size());
    }

    @GetMapping("blog1")
    @ResponseBody //json으로 데이터를 리턴
    public ResponseEntity<String> blog1() {
        return ResponseEntity.ok(blogService.findByBlogId1());
    }

    @GetMapping("blog2")
    @ResponseBody //json으로 데이터를 리턴
    public ResponseEntity<String> blog2() {
        return ResponseEntity.ok(blogService.findByBlogId2());
    }

    @GetMapping("blog3")
    @ResponseBody //json으로 데이터를 리턴
    public ResponseEntity<Blog> blog3() {
        return ResponseEntity.ok(blogService.findByBlogId3());
    }

}
