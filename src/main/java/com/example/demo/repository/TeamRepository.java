package com.example.demo.repository;

import com.example.demo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository
        extends JpaRepository<Team, Integer> {

    @Query("""
        SELECT t FROM Team t 
        JOIN FETCH t.users u
        WHERE t.teamId = :teamId
    """)
    public Team findById(@Param("teamId") int teamId);
}