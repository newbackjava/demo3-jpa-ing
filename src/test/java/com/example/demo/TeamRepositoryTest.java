package com.example.demo;

import com.example.demo.entity.Team;
import com.example.demo.entity.Users2;
import com.example.demo.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //spring의 mvc테스트용도
//@Transactional //테스트하고 자동롤백
//@DataJpaTest //@SpringBootTest + @Transactional ==> 자동롤백
public class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void findById() {
        Team team = teamRepository.findById(2);
        System.out.println("============================");
        System.out.println(team);
        System.out.println(team.getTeamId());
        System.out.println(team.getTeamName());
        System.out.println("============================");

        // Users 정보 출력
        System.out.println("============================");
        System.out.println("Team ID: " + team.getTeamId());
        System.out.println("Team Name: " + team.getTeamName());
        System.out.println("Users in this team:");
        for (Users2 user : team.getUsers2()) {
            System.out.println(" - User ID: " + user.getUserId() + ", Name: " + user.getName());
        }
        System.out.println("============================");
    }
}
