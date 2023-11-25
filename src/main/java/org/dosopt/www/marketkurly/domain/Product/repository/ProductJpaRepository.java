package org.dosopt.www.marketkurly.domain.Product.repository;

import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.domain.ProductException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
   default Product findByIdOrElseThrow(Long id) {
      return findById(id).orElseThrow(
            () -> new ProductException(CustomErrorCode.PRODUCT_NOT_FOUND));
   }
}
