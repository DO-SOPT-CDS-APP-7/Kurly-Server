package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
}
