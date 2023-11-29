package org.dosopt.www.marketkurly.domain.Product.service;

import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Product.dto.response.ProductGetResponse;
import org.dosopt.www.marketkurly.domain.Product.dto.response.SimilarProductGetResponse;
import org.dosopt.www.marketkurly.domain.Product.entity.Category;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.dosopt.www.marketkurly.domain.Product.entity.SubCategory;
import org.dosopt.www.marketkurly.domain.Product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   private final ProductRepository productRepository;

   public ProductGetResponse getById(Long id) {
      Product product = productRepository.findByIdOrElseThrow(id);
      return ProductGetResponse.of(product);
   }

   public List<SimilarProductGetResponse> getRelatedById(Long id, Pageable pageable) {
      Category productCategory = productRepository.findByIdOrElseThrow(id).getSubCategory().getCategory();
      return productRepository
               .searchByCategory(id, productCategory, pageable)
               .stream()
               .map(SimilarProductGetResponse::of)
               .collect(Collectors.toList());
   }

   public List<SimilarProductGetResponse> getRecommendedById(Long id) {
      SubCategory productSubCategory = productRepository.findByIdOrElseThrow(id).getSubCategory();
      return productRepository
               .searchBySubCategory(id, productSubCategory)
               .stream()
               .map(SimilarProductGetResponse::of)
               .collect(Collectors.toList());
   }
}
