package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;

@Entity
public class SubCategory {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   private SubCategoryType subCategoryType;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
}
