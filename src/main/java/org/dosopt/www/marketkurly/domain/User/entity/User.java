package org.dosopt.www.marketkurly.domain.User.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dosopt.www.marketkurly.domain.Cart.entity.Cart;

import java.util.ArrayList;
import java.util.List;

@Table(name="Users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String nickname;
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cart = new ArrayList<Cart>();
    @Builder
    public User(String nickname, String address){
        this.nickname = nickname;
        this.address = address;
    }
}
