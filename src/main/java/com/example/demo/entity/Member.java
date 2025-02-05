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

    //한 명의 멤버가 게시물을 여러개 쓸 수 있다.
    //member(1) : bbs(다) ==> 1:다(n)

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Bbs> bbsList;
}
