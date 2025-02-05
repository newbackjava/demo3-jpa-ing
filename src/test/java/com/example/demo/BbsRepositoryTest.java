package com.example.demo;

import com.example.demo.dto.MemberBbsDto;
import com.example.demo.entity.Bbs;
import com.example.demo.entity.Member;
import com.example.demo.repository.BbsRepository;
import com.example.demo.repository.MemberRepository;
import groovy.transform.Trait;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest //spring의 mvc테스트용도
//@Transactional //테스트하고 자동롤백
//@DataJpaTest //@SpringBootTest + @Transactional ==> 자동롤백
public class BbsRepositoryTest {

    @Autowired
    private BbsRepository bbsRepository;

    @Autowired
    private MemberRepository memberRepository;

    //넣을 때도 쓰고, 검색할 때도 쓰기 위해 전역변수로 선언!
    private Member member;
    private Bbs bbs;

    //@BeforeEach
    public void setUp() {
        member = new Member();
        member.setMemberId("testUser");
        member.setPw("1234");
        member.setName("testUser");
        member.setTel("1111");
        memberRepository.save(member);

        bbs = new Bbs();
        bbs.setTitle("testBbs");
        bbs.setContent("testBbs");
        bbs.setMember(member);

        bbsRepository.save(bbs);
    }

    @Test
    public void testFindBbsNo() {
        MemberBbsDto result = bbsRepository.findBbsWithMember(3L);
        System.out.println("##########################");
        System.out.println("##########################");
        System.out.println(result);
        System.out.println("##########################");
        System.out.println("##########################");
        assertNotNull(result);
        assertEquals(3L, result.getBbsNo());
        assertEquals("testBbs", result.getTitle());
    }
}
