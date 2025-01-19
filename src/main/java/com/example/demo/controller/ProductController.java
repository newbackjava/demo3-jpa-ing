package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("product")
    public String product(Model model){
        List<Product> list = productService.findAll();
        System.out.println("---------------------------------------");
        System.out.println(list);
        model.addAttribute("list", list);
        return "product/product";
    }

    @GetMapping("read/{productId}")
    public String read(@PathVariable Long productId, Model model){
        System.out.println(productId + "================================");
        Product product = productService.findById(productId);
        System.out.println("---------------------------------------");
        System.out.println(product);
        model.addAttribute("product", product);
        return "product/read";
    }


}
