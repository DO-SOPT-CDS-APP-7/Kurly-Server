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

import java.text.DecimalFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserJpaRepository userJpaRepository;
    static final int freeShippingPrice = 50000;

    @Transactional
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

    @Transactional
    public void deleteCartItems(Long cartId){
        if(cartItemRepository.findByCartId(cartId) == null)
                throw new CartException(CustomErrorCode.CARTITEM_NOT_FOUND);
        cartItemRepository.deleteAllByCart_Id(cartId);
    }
    @Transactional
    public String getFreeShippingPrice(Long userId){
        int totalPrice = 0;
        int remainPrice = 0;
        //장바구니에 담은 상품이 없는 경우, default 값인 50000원 반환
        Long cartId = cartRepository.findByUserId(userId).getId();
        List<CartItemGetResponse> cartItems = cartItemRepository.findItemsByCartId(cartId);

        for(CartItemGetResponse item:cartItems) {
            totalPrice += item.getCount()*item.getPrice() * (1-item.getDiscountRate()*0.01);
        }

        remainPrice = freeShippingPrice - totalPrice;
        if(remainPrice>0) return new DecimalFormat("#,###원").format(remainPrice);
        return "0원";
    }

    /*QueryDsl*/
    @Transactional
    public List<CartItemGetResponse> findCartItems(Long cartId){
        if(cartItemRepository.findByCartId(cartId) == null)
            throw new CartException(CustomErrorCode.CART_NOT_FOUND);

        return cartItemRepository.findItemsByCartId(cartId);
    }

}
