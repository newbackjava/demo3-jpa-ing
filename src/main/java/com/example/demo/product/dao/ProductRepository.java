package com.example.demo.product.dao;

import com.example.demo.board.vo.Board;
import com.example.demo.product.vo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
