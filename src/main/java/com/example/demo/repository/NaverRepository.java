package com.example.demo.repository;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Naver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaverRepository
        extends JpaRepository<Naver, String> {
}
