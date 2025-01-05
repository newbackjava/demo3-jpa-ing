package com.example.demo.cart.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDetailsDto {
    private long cartNo;
    private String memberId;
    private String memberName;
    private String memberTel;
    private long productId;
    private String productName;
    private int productPrice;
    private int count;
}
