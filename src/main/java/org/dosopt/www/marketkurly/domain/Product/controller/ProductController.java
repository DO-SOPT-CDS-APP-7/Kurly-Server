package org.dosopt.www.marketkurly.domain.Product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Product.dto.response.ProductGetResponse;
import org.dosopt.www.marketkurly.domain.Product.service.ProductService;
import org.dosopt.www.marketkurly.global.result.ResultCode;
import org.dosopt.www.marketkurly.global.result.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "PRODUCT cotroller", description = "상품 API입니다.")
public class ProductController {
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   private final ProductService productService;
   @Operation( summary = "특정 상품 조회",
         description = "사용자가 특정 상품을 조회합니다.",
         parameters = { @Parameter(name = "productId", description = "상품 ID (상품설명 화면에서 productId=1 값 사용)",
               in = ParameterIn.PATH, schema = @Schema(defaultValue = "1")) } )
   @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과 ➡️ ProductGetResponse",
               content = @Content(schema = @Schema(implementation = ProductGetResponse.class))) } )
   @GetMapping("/{productId}")
   public ResultResponse<ProductGetResponse> getProductById(@PathVariable("productId") Long id) {
      return ResultResponse.of(ResultCode.GET_PRODUCT_SUCCESS, productService.getById(id));
   }
}
