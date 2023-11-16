package org.dosopt.www.marketkurly.domain.Product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dosopt.www.marketkurly.global.result.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PRODUCT cotroller", description = "상품 API입니다.")
@RestController
public class ProductController {
   @Operation( summary = "특정 상품 조회",
         description = "사용자가 특정 상품을 조회합니다.",
         tags = "PRODUCT",
         parameters = { @Parameter(name = "productId", description = "상품 ID", in = ParameterIn.PATH) }
   )
   @GetMapping("/{productId}")
   public void getProductById(@PathVariable("productId") Long id) {
   }
}
