package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private CategoryType categoryType;

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
   private List<SubCategory> subCategories;
}
