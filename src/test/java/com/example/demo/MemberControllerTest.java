package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //Junit라이브러리와 함께 controller에 명시된
    //주소를 http통신으로 호출하고 결과를 받아볼 수 있는 
    //라이브러리

    @Test
    @DisplayName("Get요청 테스트")
    public void getMember() throws Exception {
        mockMvc.perform(get("/member/member"))
                .andExpect(status().isOk())
                .andExpect(content().string("내가 주장하는 문자열"));
    }

    @Test
    @DisplayName("read+파라메터 요청 테스트")
    public void getMember2() throws Exception {
        mockMvc.perform(post("/member/read")
                            .param("id", "apple"))
                .andExpect(status().isOk())
                .andExpect(content().string("내가 주장하는 문자열"));
    }
}
