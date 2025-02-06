package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member2") // 테이블 이름 명시
public class Member2 {

    @Id
    private String memberId;

    @Column(nullable = false) // NotNull에 대응
    private String pw;

    @Column
    private String name;

    @Column
    private String tel;
}
