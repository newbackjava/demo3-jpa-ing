package com.example.demo.board.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data //get/set, toString코드 자동 생성
@NoArgsConstructor //기본 생성자 자동 생성
@AllArgsConstructor //모든 멤버변수 생성자 자동 생성
@EntityListeners(AuditingEntityListener.class)
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content, Long bno) {
        this.bno = bno;
        this.title = title;
        this.content = content;
    }
}
