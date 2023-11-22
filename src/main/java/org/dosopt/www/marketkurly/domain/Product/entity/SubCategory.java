package org.dosopt.www.marketkurly.domain.Product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubCategory {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true)
   @Enumerated(EnumType.STRING)
   private SubCategoryType subCategoryType;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
}
