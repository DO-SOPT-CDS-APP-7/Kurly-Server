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
import org.dosopt.www.marketkurly.domain.Product.dto.response.SimilarProductGetResponse;
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
         description = "사용자가 ✔️특정 상품✔️을 조회합니다.",
         parameters = { @Parameter(name = "productId", description = "상품 ID (상품설명 화면에서 productId=1 값 사용)",
               in = ParameterIn.PATH, schema = @Schema(defaultValue = "1")) } )
   @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과 ➡️ ProductGetResponse",
               content = @Content(schema = @Schema(implementation = ProductGetResponse.class))) } )
   @GetMapping("/{productId}")
   public ResultResponse<ProductGetResponse> getProductById(@PathVariable("productId") Long id) {
      return ResultResponse.of(ResultCode.GET_PRODUCT_SUCCESS, productService.getById(id));
   }

   @Operation( summary = "다른 고객이 함께 본 상품 조회",
         description = "사용자가 상품을 찜/구매/조회한 경우, ✔️다른 고객이 함께 본 상품✔️을 조회합니다.",
         parameters = {
               @Parameter(name = "productId", description = "상품 ID", in = ParameterIn.PATH),
               @Parameter(name = "count", description = "응답할 상품 개수", in = ParameterIn.QUERY, required = true) } )
   @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과 ➡️ SimilarProductGetResponse",
         content = @Content(schema = @Schema(implementation = SimilarProductGetResponse.class))) } )
   @GetMapping("/{productId}/related")
   public ResultResponse<SimilarProductGetResponse> getRelatedProductById(@PathVariable("productId") Long id,
                                                                          @RequestParam(value = "count", defaultValue = "3") Integer count) {
      return ResultResponse.of(ResultCode.GET_SIMILAR_PRODUCT_SUCCESS, productService.getRelatedById(id, count));
   }
}
