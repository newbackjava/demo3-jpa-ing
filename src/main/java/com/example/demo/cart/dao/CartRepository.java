package com.example.demo.cart.dao;

import com.example.demo.cart.entity.CartDetailsDto;
import com.example.demo.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c " +
            "WHERE c.productId = :productId and c.memberId = :memberId"
    )
    Cart findProductByProductIdMemberId(@Param("productId") long productId,
                                        @Param("memberId") String memberId);

    @Query("SELECT new com.example.demo.cart.entity.CartDetailsDto(" +
            "c.no, m.memberId, m.name, m.tel, p.productId, p.name, p.price, c.count) " +
            "FROM Cart c " +
            "JOIN c.product p " +
            "JOIN c.member m " +
            "WHERE m.memberId = :memberId")
    List<CartDetailsDto> findCartsByMemberId(@Param("memberId") String memberId);

//    @Modifying
//    @Query("UPDATE Cart c " +
//            "SET c.count = CASE " +
//            "WHEN c.id IN :cartIds THEN :cartQuantities " +
//            "END " +
//            "WHERE c.id IN :find   "
//    )


}
