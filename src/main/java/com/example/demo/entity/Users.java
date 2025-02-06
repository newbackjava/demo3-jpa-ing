package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private Long UserId;
    private String name;
    //Team과의 관계성 설정 추가 예정

    //관계성설정해놓으면
    //join하지 않고 Users만 검색해도
    //Team같이 검색을 해오게 된다.
    //default 설정이 FetchType.EAGER되어있음.
    //LAZY로 변경하면 일단 Team은 가지고 오지 않음.
    //Users가지고 온 다음에 getTeam()이라고 하면
    //그 때서야 Team정보를 db에서 가지고 오게 된다.
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "teamId",
                referencedColumnName = "teamId"
    )
   @ToString.Exclude  // 무한 순환 방지
    private Team team;
}
