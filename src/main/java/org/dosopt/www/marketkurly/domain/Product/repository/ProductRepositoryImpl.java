package org.dosopt.www.marketkurly.domain.Product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static org.dosopt.www.marketkurly.domain.Product.entity.QProduct.product;
import static org.dosopt.www.marketkurly.domain.Product.entity.QCategory.category;

import org.dosopt.www.marketkurly.domain.Product.entity.Category;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.entity.SubCategory;
import org.dosopt.www.marketkurly.domain.Product.repository.querydsl.ProductCustomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepository {

   private final JPAQueryFactory jpaQueryFactory;
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   private static final int subCategoryCount = 3;

   @Override
   public List<Product> searchByCategory(Long productId, Category category, Pageable pageable) {
      return jpaQueryFactory
               .selectFrom(product)
               .where(product.subCategory.category.categoryType.eq(category.getCategoryType())
                     .and(product.id.ne(productId)))
               .orderBy(product.updatedAt.desc())
               .offset(pageable.getOffset())
               .limit(pageable.getPageSize())
               .fetch();
   }

   @Override
   public List<Product> searchBySubCategory(Long productId, SubCategory subCategory) {
      return jpaQueryFactory
               .selectFrom(product)
               .where(product.subCategory.subCategoryType.eq(subCategory.getSubCategoryType())
                     .and(product.id.ne(productId)))
               .orderBy(product.updatedAt.desc())
               .limit(subCategoryCount)
               .fetch();
   }
}
