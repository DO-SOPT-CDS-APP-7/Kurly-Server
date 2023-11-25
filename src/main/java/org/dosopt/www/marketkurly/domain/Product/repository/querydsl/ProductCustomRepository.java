package org.dosopt.www.marketkurly.domain.Product.repository.querydsl;

import org.dosopt.www.marketkurly.domain.Product.dto.response.SimilarProductGetResponse;
import org.dosopt.www.marketkurly.domain.Product.entity.Category;
import org.dosopt.www.marketkurly.domain.Product.entity.CategoryType;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {
   List<Product> searchByCategory(Category category, Pageable pageable);
}
