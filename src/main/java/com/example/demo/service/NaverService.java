package com.example.demo.service;

import com.example.demo.entity.Naver;
import com.example.demo.repository.NaverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverService {

    private final NaverRepository naverRepository;

    public void insert(Naver naver){
        naverRepository.save(naver);//insert, update
        //save() : pk(@Id)가 없으면 insert, 있으면 update
    }
}
