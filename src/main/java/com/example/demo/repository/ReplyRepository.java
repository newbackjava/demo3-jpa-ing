package com.example.demo.repository;

import com.example.demo.dto.AllDto;
import com.example.demo.dto.BbsReplyDto;
import com.example.demo.dto.ReplyMemberDto;
import com.example.demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("""
        SELECT new com.example.demo.dto.AllDto
            (r.replyNo, r.content, r.writer, b.title, m.name)
        FROM Reply r
        JOIN Bbs2 b ON r.bbsNo = b.bbsNo
        JOIN Member2 m ON r.writer = m.memberId
        WHERE m.memberId = :memberId
        ORDER BY r.bbsNo
    """)
    List<AllDto> findAllDto(@Param("memberId") String memberId);

    @Query("""
        SELECT new com.example.demo.dto.BbsReplyDto
            (b.bbsNo, r.replyNo, b.title, b.content)
        FROM Reply r
        JOIN Bbs2 b ON r.bbsNo = b.bbsNo
        WHERE b.bbsNo = :bbsNo
    """)
    List<BbsReplyDto> replyBbs(@Param("bbsNo") Long bbsNo);

    @Query("""
        SELECT new com.example.demo.dto.ReplyMemberDto
            (r.replyNo, m.memberId, m.name, r.content)
        FROM Member m
        JOIN Reply r ON r.writer = m.memberId
        WHERE r.replyNo = :replyNo
    """)
    List<ReplyMemberDto> replyMember(@Param("replyNo") Long replyNo);

    @Query("SELECT r FROM Reply r WHERE r.replyNo = :replyNo")
    Reply findReply(@Param("replyNo") Long replyNo);
}