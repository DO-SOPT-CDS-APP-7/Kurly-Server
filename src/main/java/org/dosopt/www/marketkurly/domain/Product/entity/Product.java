package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;

@Entity
public class Product {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String productName;

   private Integer price;

   private String imageURL;

   private Integer discountRate;
   @Enumerated(EnumType.STRING)
   private DeliveryType deliveryType;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "seller_id")
   private Seller seller;
}
