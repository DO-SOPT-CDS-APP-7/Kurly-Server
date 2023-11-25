package org.dosopt.www.marketkurly.domain.Product.service;

import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Product.dto.response.ProductGetResponse;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
   private final ProductJpaRepository productJpaRepository;
   public ProductGetResponse getById(Long id) {
      Product product = productJpaRepository.findByIdOrElseThrow(id);
      return ProductGetResponse.of(product);
   }
}
