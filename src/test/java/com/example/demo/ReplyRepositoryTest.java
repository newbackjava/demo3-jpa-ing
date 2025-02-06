package com.example.demo;

import com.example.demo.dto.AllDto;
import com.example.demo.dto.BbsReplyDto;
import com.example.demo.dto.ReplyMemberDto;
import com.example.demo.entity.Reply;
import com.example.demo.repository.ReplyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyRepositoryTest {

    //Repository di로 한 다음
    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void test() {
        //조금 전에 만들었던 allDto리턴 테스트해보세요.!!!
        List<AllDto> list = replyRepository.findAllDto("user1");
        System.out.println("======================");
        list.forEach(System.out::println);
        System.out.println("======================");
        Assertions.assertEquals(4, list.size());
    }

    //문제 1
    @Test
    public void test2() {
        List<BbsReplyDto>  list = replyRepository. replyBbs(1L);
        System.out.println("======================");
        list.forEach(System.out::println);
        System.out.println("======================");
        Assertions.assertEquals(4, list.size());
    }

    //문제 2
    @Test
    public void test4() {
        Reply reply = replyRepository.findReply(1L);
        System.out.println("======================");
        System.out.println(reply);
        System.out.println("======================");
    }

    //문제 3
    @Test
    public void test3() {
        List<ReplyMemberDto>  list = replyRepository. replyMember(1L);
        System.out.println("======================");
        list.forEach(System.out::println);
        System.out.println("======================");
        Assertions.assertEquals(4, list.size());
    }


}
