package com.example.demo.repository;

import com.example.demo.entity.Young;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface YoungRepository
        extends JpaRepository<Young, String> {
}

