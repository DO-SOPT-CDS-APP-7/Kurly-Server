package org.dosopt.www.marketkurly.domain.Product.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Product.dto.response.SimilarProductGetResponse;
import static org.dosopt.www.marketkurly.domain.Product.entity.QProduct.product;

import org.dosopt.www.marketkurly.domain.Product.entity.Category;
import org.dosopt.www.marketkurly.domain.Product.entity.CategoryType;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.repository.querydsl.ProductCustomRepository;
import org.dosopt.www.marketkurly.global.entity.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepository {
   private final JPAQueryFactory jpaQueryFactory;
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   @Override
   public List<Product> searchByCategory(Category category, Pageable pageable) {
      return jpaQueryFactory
            .selectFrom(product)
            .where(product.category.categoryType.eq(category.getCategoryType()))
            .orderBy(product.updatedAt.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();
   }
}
