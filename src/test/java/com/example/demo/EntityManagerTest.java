package com.example.demo;

import com.example.demo.board.vo.Board;
import com.example.demo.product.vo.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void test(){
        Product product = Product.builder()
                .productId(1L)
                .name("shoes")
                .content("summer shoes")
                .price(10000)
                .company("nike")
                .build();

        //엔티티 객체가 관리되는 상태
        em.persist(product);
        //엔티티 객체가 분리되는 상태
        em.detach(product);
        //엔티티객체가 삭제된 상태
        em.remove(product);
    }
}
