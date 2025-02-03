package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public String product(Model model){
        List<Product> list = productService.findAll();
        System.out.println("---------------------------------------");
        System.out.println(list);
        model.addAttribute("list", list);
        return "product/product";
    }

    @GetMapping("/read/{productId}")
    public String read(@PathVariable Long productId, Model model){
      /////////////////////////////////////////////////////////////
        System.out.println("productId: " + productId);
        Product product = productService.findById(productId);
        System.out.println("------------------------------------");
        System.out.println("product: " + product);
        model.addAttribute("product", product);
      ///////////////////////////////////////////////////////////
        return "product/read";
    }

    @GetMapping("/update/{productId}")
    public String update(@PathVariable Long productId, Model model){
      /////////////////////////////////////////////////////////////
        System.out.println("productId: " + productId);
        //검색후 모델로 지정후 수정화면으로 넘어감.
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
      ///////////////////////////////////////////////////////////
        return "product/update";
    }

    @PostMapping("/update2")
    public String update2(Product product, Model model) {
      /////////////////////////////////////////////////////////////
        System.out.println("product: " + product);
        productService.save(product);
      ///////////////////////////////////////////////////////////
        return "redirect:/product/product";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable Long productId, Model model){
      /////////////////////////////////////////////////////////////
        System.out.println("productId: " + productId);
        productService.delete(productId);
      ///////////////////////////////////////////////////////////
        return "redirect:/product/product";
    }
}
