package com.example.demo.cart.service;

import com.example.demo.cart.dao.CartRepository;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.entity.CartDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    @Transactional(readOnly = true)
    public List<CartDetailsDto> getCartsByMemberId(String memberId) {
        return cartRepository.findCartsByMemberId(memberId);
    }


    public Cart save(Cart cart) {
        //저장하기전 이미 장바구니에 있는지 확인
        Cart findCart = cartRepository.findProductByProductIdMemberId(cart.getProductId(), cart.getMemberId());
        System.out.println("------------------------------------------------------------");
        
        if (findCart == null) {
            findCart = cartRepository.save(cart);
        }else{
            findCart.setCount(findCart.getCount() + 1);
            findCart = cartRepository.save(findCart);
        }

//        Cart cart = cartRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));
//
//        cart.setCount(newCount); // 필드 값 변경
//        return cartRepository.save(cart); // 업데이트 실행

        return findCart;
    }

//    @Transactional
//    public void updateCartQuantity(String memberId, long productId, int count) {
//        int updatedRows = cartRepository.updateCartQuantity(count, memberId, productId);
//        if (updatedRows == 0) {
//            throw new IllegalArgumentException("Cart item not found for memberId: " + memberId + " and productId: " + productId);
//        }
//    }
}
