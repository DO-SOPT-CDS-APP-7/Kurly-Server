package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dosopt.www.marketkurly.global.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String productName;

   private Integer price;

   private String imageURL;

   private Integer discountRate;

   @Enumerated(EnumType.STRING)
   private DeliveryType deliveryType;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "category_id")
   private Category category;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "seller_id")
   private Seller seller;
}
