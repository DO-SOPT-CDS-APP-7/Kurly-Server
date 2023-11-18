package org.dosopt.www.marketkurly.domain.Product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.dosopt.www.marketkurly.global.result.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PRODUCT cotroller", description = "상품 API입니다.")
@RestController
public class ProductController {
   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   @Operation( summary = "특정 상품 조회",
         description = "사용자가 특정 상품을 조회합니다.",
         tags = "PRODUCT",
         parameters = { @Parameter(name = "productId", description = "상품 ID", in = ParameterIn.PATH) }
   )
   @GetMapping("/{productId}")
   public void getProductById(@PathVariable("productId") Long id) {
      logger.trace("Trace Level 테스트");
      logger.debug("DEBUG Level 테스트");
      logger.info("INFO Level 테스트");
      logger.warn("Warn Level 테스트");
      logger.error("ERROR Level 테스트");
   }
}
