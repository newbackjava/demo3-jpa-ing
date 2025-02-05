package com.example.demo.repository;

import com.example.demo.entity.Bbs2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bbs2Repository extends JpaRepository<Bbs2, Long> {
//    @Override
//    default Page<Bbs2> findAll(Pageable pageable) {
//        return null;
//    }
    //모든 리스트를 가지고 오는 기능은 jpa인터페이스에서 제공하고 있음.
    //그냥 쓰면 됨.
}
