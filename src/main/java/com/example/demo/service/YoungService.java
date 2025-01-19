package com.example.demo.service;

import com.example.demo.repository.YoungRepository;
import com.example.demo.entity.Young;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YoungService {

    private final YoungRepository youngRepository;

    public void insert() {
        YoungParser parser = new YoungParser();
        List<Young> list = parser.parse();

        int index = 1;
        for (Young young : list) {
            if (young.getRqutProcCn().length() >= 200){
                young.setRqutProcCn(young.getRqutProcCn().substring(0, 200));
            }
             youngRepository.save(young);
            System.out.println(index + ">> ");
            index++;
        }
    }

    public List<Young> findAll() {
        return youngRepository.findAll();
    }
}