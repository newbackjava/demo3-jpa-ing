package com.example.demo.member.vo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get/set, toString코드 자동 생성
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor //모든 멤버변수 생성자 자동 생성
@Builder
@Entity
public class Member {
    @Id
    private String memberId;
    private String pw;
    private String name;
    private String tel;
}
