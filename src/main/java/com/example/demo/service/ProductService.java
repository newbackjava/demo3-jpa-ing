package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //전체 검색
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //id를 가지고 상세검색
    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    //insert용, 없으면!!!
    public Product save(Product product) {
        return productRepository.save(product);
    }

    //id를 주고 해당 row삭제
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    //update용, 있으면!!!
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
