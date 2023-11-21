package org.dosopt.www.marketkurly.domain.Cart.service;

import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Cart.dto.request.CartItemAddRequest;
import org.dosopt.www.marketkurly.domain.Cart.entity.Cart;
import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;
import org.dosopt.www.marketkurly.domain.Cart.repository.CartItemJpaRepository;
import org.dosopt.www.marketkurly.domain.Cart.repository.CartJpaRepository;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.repository.ProductJpaRepository;
import org.dosopt.www.marketkurly.domain.User.UserJpaRepository;
import org.dosopt.www.marketkurly.domain.User.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final ProductJpaRepository productJpaRepository;
    private final CartJpaRepository cartJpaRepository;
    private final CartItemJpaRepository cartItemJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public Long addCart(CartItemAddRequest cartRequest, Long userId){
        Product product = productJpaRepository.findByIdOrElseThrow(cartRequest.getProductId());
        User user = userJpaRepository.findByIdOrElseThrow(userId);
        Cart cart = cartJpaRepository.findByUserId(userId);

        if(cart == null){
            cart = Cart.createCart(user);
            cartJpaRepository.save(cart);
        }

        CartItem savedCartItem = cartItemJpaRepository.findByCartIdAndProductId(cart.getId(), product.getId());

        if (savedCartItem != null){
            savedCartItem.addCount(cartRequest.getCount());
            return savedCartItem.getId();
        } else{
            CartItem cartItem = CartItem.createCartItem(cart, product, cartRequest.getCount());
            cartItemJpaRepository.save(cartItem);
            return cartItem.getId();
        }
    }
}
