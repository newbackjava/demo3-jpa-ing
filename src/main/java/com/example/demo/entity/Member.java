package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member") // 테이블 이름 명시
public class Member {

    @Id
    private String memberId;

    @Column(nullable = false) // NotNull에 대응
    private String pw;

    @Column
    private String name;

    @Column
    private String tel;
}
