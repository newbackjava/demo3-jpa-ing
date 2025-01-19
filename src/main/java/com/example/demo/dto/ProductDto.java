package com.example.demo.dto;

import com.example.demo.entity.Product;
import groovy.transform.builder.Builder;
import lombok.Value;

import java.io.Serializable;

@Value //생성자, private final, getter
@Builder
public class ProductDto {
    long productId;
    String name;
    String content;
    String company;
    int price;
}