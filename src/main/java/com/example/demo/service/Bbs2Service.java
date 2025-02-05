package com.example.demo.service;

import com.example.demo.entity.Bbs2;
import com.example.demo.repository.Bbs2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자를 반드시 만들어서, di해주세요.!!!
public class Bbs2Service {

    private final Bbs2Repository bbs2Repository;

    //전체 리스트 중에서 특정한 페이지만 가지고 오는 기능
    public Page<Bbs2> findAll(Pageable pageable) {
        return bbs2Repository.findAll(pageable);
    }
}
