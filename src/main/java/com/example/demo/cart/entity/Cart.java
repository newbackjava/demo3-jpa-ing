package com.example.demo.cart.entity;

import com.example.demo.product.vo.Product;
import com.example.demo.member.vo.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Builder;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private Product product;

    @Column(name = "productId")
    private long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", referencedColumnName = "memberId", insertable = false, updatable = false)
    private Member member;

    @Column(name = "memberId")
    private String memberId;

    @NonNull
    private int count = 1;
}
