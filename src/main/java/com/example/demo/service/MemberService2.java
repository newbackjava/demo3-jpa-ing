package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService2 {
    
    public int deleteMember(int id) {
        //return 0; //삭제 실패
        return 1; //삭제 성공
    }
}
