package org.dosopt.www.marketkurly.domain.Cart.entity;

import jakarta.persistence.*;
import lombok.*;
import org.dosopt.www.marketkurly.domain.User.entity.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public static Cart createCart(User user){
        Cart cart = new Cart();
        cart.setUser(user);
        return cart;
    }
}
