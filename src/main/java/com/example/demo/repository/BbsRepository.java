package com.example.demo.repository;

import com.example.demo.dto.MemberBbsDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {

    //게시물 1번쓴사람에 대한 정보+게시물 정보를 조인 검색
    //bbs의 bbsNo, title, content, member의 id, name
    @Query("""
     select new com.example.demo.dto.MemberBbsDto
          (b.bbsNo, b.title, b.content, m.memberId, m.name)
          from Bbs b JOIN b.member m
          where b.bbsNo = :bbsNo
     """)
    MemberBbsDto findBbsWithMember(@Param("bbsNo") Long bbsNo);
}
