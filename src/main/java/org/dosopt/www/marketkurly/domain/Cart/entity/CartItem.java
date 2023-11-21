package org.dosopt.www.marketkurly.domain.Cart.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItem_id")
    private Long id;

    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Builder
    public CartItem(Product product, Cart cart){
        this.product = product;
        this.cart = cart;
    }

    public static CartItem createCartItem(Cart cart, Product product, int count){
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setCount(count);
        return cartItem;
    }

    public void addCount(int count){
        this.count += count;
    }


}
