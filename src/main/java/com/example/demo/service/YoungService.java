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

    //검색(전체)
    public List<Young> findAll() {
        return youngRepository.findAll();
    }
    //inset여러개- 파싱결과 db에 넣기
    public void insert(){
        //파서가 파싱한 결과를 List로 받아와서
        //글자들이 너무 길면 200자까지만 잘라서 다시 집어 넣어
        //db에 넣자.
        ApiYoungParser parser = new ApiYoungParser();
        List<Young> list = parser.young();
        for (Young young : list) {
            if (young.getRqutProcCn().length() > 200){
                young.setRqutProcCn(young.getRqutProcCn().substring(0, 200));
            }
            youngRepository.save(young);
        }
    }
    
}