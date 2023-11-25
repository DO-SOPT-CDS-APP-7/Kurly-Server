package org.dosopt.www.marketkurly.domain.Cart.service;

import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Cart.dto.request.CartItemAddRequest;
import org.dosopt.www.marketkurly.domain.Cart.dto.response.CartItemGetResponse;
import org.dosopt.www.marketkurly.domain.Cart.entity.Cart;
import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;
import org.dosopt.www.marketkurly.domain.Cart.repository.CartItemRepository;
import org.dosopt.www.marketkurly.domain.Cart.repository.CartRepository;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.repository.ProductRepository;
import org.dosopt.www.marketkurly.domain.User.UserJpaRepository;
import org.dosopt.www.marketkurly.domain.User.entity.User;
import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.domain.CartException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserJpaRepository userJpaRepository;

    public Long addCart(CartItemAddRequest cartRequest, Long userId){
        Product product = productRepository.findByIdOrElseThrow(cartRequest.getProductId());
        User user = userJpaRepository.findByIdOrElseThrow(userId);
        Cart cart = cartRepository.findByUserId(userId);

        if(cart == null){
            cart = Cart.createCart(user);
            cartRepository.save(cart);
        }

        CartItem savedCartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), product.getId());

        if (savedCartItem != null){
            savedCartItem.addCount(cartRequest.getCount());
            return savedCartItem.getId();
        } else{
            CartItem cartItem = CartItem.createCartItem(cart, product, cartRequest.getCount());
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }
    }

    /*QueryDsl*/
    public List<CartItemGetResponse> findCartItems(Long cartId){
        CartItem cartItems = cartItemRepository.findById(cartId).orElseThrow(
                () -> new CartException(CustomErrorCode.CART_NOT_FOUND));

        return cartItemRepository.findByCartId(cartId);
    }

}
