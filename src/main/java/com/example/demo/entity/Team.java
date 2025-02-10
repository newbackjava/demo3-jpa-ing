package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//하나의 팀안에는 여러 유저들이 있다.
//1(팀) : n(유저)
public class Team {
    @Id
    private int teamId;
    private String teamName;
    //관계성 성립, users

    @OneToMany(mappedBy = "team",
                fetch = FetchType.LAZY)
    @ToString.Exclude  // 무한 순환 방지
    private List<Users2> users2;
}
