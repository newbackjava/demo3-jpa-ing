package com.example.demo.controller;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.Message2;
import com.example.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Value
@Controller
@RequiredArgsConstructor
public class ChatController {

    private ChatService chatService;

    @MessageMapping("/chatbot") // 클라이언트가 "/app/sendMessage"로 보낸 메시지를 처리
    @SendTo("/topic/chatbot")     // 구독한 클라이언트에게 "/topic/messages"로 전달
    public Message2 sendMessage(@RequestBody Message2 message2) {
        System.out.println("message2 >>> " + message2);
        /// /////////코드 추가 ///////////
        //Chat chat1 = chatService.saveMessage(chat);
        /// ///////////////////////////

        //챗봇 시나리오//
        System.out.println("받은 데이터>>" + message2);
        String menu = "";
        switch (message2.getText()) {
            case "시작":
                menu = "챗 봇>>  1) 상품소개 2) 주문확인";
                break;
            case "1":
                menu = "챗 봇>>  10) 운동화       11) 모자       12) 가방";
                break;
            case "2":
                menu = "챗 봇>>  20) 배송조회 21) 주문완료상품조회";
                break;
            case "20":
                menu = "챗 봇>> DB에서 가지고 온 배송 상황 목록 <br>" +
                        "상품명: 르꼬뿌  배송상황: 물건 준비중";
                break;
            case "10":
                menu = "챗 봇>>  100) 나이커     200) 르꼬뿌         300) 라코스또";
                break;
            case "100":
                menu = "챗 봇>>  1000) 나이커 운동화 세부 메뉴  1) 다시 처음 메뉴";
                break;
            case "1000":
                menu = "챗 봇>>  1001)나이커빨강(1만원)  1002)나이커파랑(2만원)    1003)나이커보라(3만원)    100)이전 메뉴로";
                break;
            default:
                menu = "챗 봇>>선택한 번호는 없는 메뉴입니다. 다시 입력해주세요.";
                break;
        }
        message2.setMenu(menu);
        return message2;
        //return chat1;
    }

    @MessageMapping("/chatting")
    @SendTo("/topic/chatting")
    public Message sendMessage2(@RequestBody Message message) {
        System.out.println("messageVO >>> " + message);
        Date date = new Date();
        message.setTime(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        return message; //쓴사람 + 내용 + 시각, json형태로 감.
    }

//    @MessageMapping("/chatbot") // 클라이언트에서 "/app/sendMessage"로 보낸 메시지 처리
//    @SendTo("/topic/chatbot") // "/topic/messages"로 메시지 전달
//    public String chatbot(String message) {
//        return message; // 메시지를 그대로 반환
//    }

    @GetMapping("chat/chat")
    public String chat() {
        return "chat/chat";
    }

    @GetMapping("chat/chat2") //챗봇 또는 채팅 선택 화면
    public String chat2() {
        return "chat/chat2";
    }

    @GetMapping("chat/chatting") //채팅 입력방 화면
    public String chatting() {
        return "chat/chatting";
    }

}
