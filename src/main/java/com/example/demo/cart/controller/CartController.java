package com.example.demo.cart.controller;

import com.example.demo.cart.entity.CartDetailsDto;
import com.example.demo.cart.service.CartService;
import com.example.demo.cart.entity.Cart;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("cart")
    public String cart(HttpSession session, Model model) {
        List<CartDetailsDto> list = cartService.getCartsByMemberId(session.getAttribute("id").toString());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(list);
        model.addAttribute("carts", list);
        return "cart/cart";
    }

    @PostMapping("create")
    @ResponseBody
    public boolean create(@RequestBody Cart cart){
        System.out.println(cart);

        Cart cart2 = cartService.save(cart);
        if (cart2 != null) {
            return true;
        }else {
            return true;
        }
    }

    @PostMapping("update")
    public String updateOrDeleteCart(
            @RequestParam(name = "cartIds", required = false) List<Long> cartIds,
            @RequestParam(name = "cartQuantities", required = false) List<Integer> cartQuantities,
            @RequestParam(name = "selectedCartIds", required = false) List<Long> selectedCartIds) {

            // 수량 수정 로직
//            if (cartIds != null && cartQuantities != null) {
//                for (int i = 0; i < cartIds.size(); i++) {
//                    cartService.updateCartQuantity(cartIds.get(i), cartQuantities.get(i));
//                }
//            }
       return "redirect:/cart"; // 수정 후 다시 장바구니 페이지로 이동
    }


}
