package com.example.demo.service;

import com.example.demo.dto.BlogDto;
import com.example.demo.entity.Blog;
import com.example.demo.naver.APIExamTranslate3KO;
import com.example.demo.naver.OCRGeneralAPIDemo2;
import com.example.demo.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public String trans(String word) {
        APIExamTranslate3KO ko = new APIExamTranslate3KO();
        return ko.trans(word);
    }

    public Blog insert(BlogDto blogDto) {
        //1. dto에 있는 것을  vo로 옮겨주고
        Blog blog = Blog.builder()
                .name(blogDto.getName())
                .mail(blogDto.getMail())
                .content(blogDto.getContent())
                .img(blogDto.getImg())
                .build();

        //2. vo의 img를 ocr주면서 추출한 문자열을 결과로 받아온다.
        OCRGeneralAPIDemo2 ocr = new OCRGeneralAPIDemo2();
        String result = ocr.ocr(blog.getImg());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("추출한 result: " + result);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        //3. db에 저장
        //추출한 이미지 entity에 넣어주자.
        blog.setContent2(result);
        return blogRepository.save(blog); //db용으로는 entity를 사용
        //db이외에 전달할 때만 dto를 쓴다.

    }
    /**
     * 전체 Blog의 수를 반환
     */
    public long totalCount () {
        return blogRepository.totalCount();
    }

    /**
     * blogId가 3 이상인 Blog의 수를 반환
     */
    public long up3 () {
        return blogRepository.up3();
    }

    /**
     * '행복'이라는 단어가 포함된 Blog를 반환
     */
    public List<Blog> findHappy() {
        return blogRepository.findHappy();
    }

    //id로 content를 검색--> return이 string
    public String findByBlogId1 () {
        return blogRepository.findByBlogId1();
    }

    //id로 content를 검색--> return이 string
    public String findByBlogId2 () {
        return blogRepository.findByBlogId2();
    }

    //id로 content, mail을 검색--> return이 entity(vo)
    public Blog findByBlogId3 () {
        return blogRepository.findByBlogId3();
    }
}
