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
import org.dosopt.www.marketkurly.global.entity.PageRequest;
import org.dosopt.www.marketkurly.global.result.ResultCode;
import org.dosopt.www.marketkurly.global.result.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
         parameters = { @Parameter(name = "productId", description = "상품 ID",
                                    in = ParameterIn.PATH, schema = @Schema(defaultValue = "1")),
               @Parameter(name = "page", description = "페이지 번호 (Minimum : 1)", in = ParameterIn.QUERY),
               @Parameter(name = "size", description = "한 페이지 당 받을 데이터 개수", in = ParameterIn.QUERY) } )
   @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과 ➡️ SimilarProductGetResponse",
         content = @Content(schema = @Schema(implementation = SimilarProductGetResponse.class))) } )
   @GetMapping("/{productId}/related")
   public ResultResponse<List<SimilarProductGetResponse>> getRelatedProductById(@PathVariable("productId") Long id,
                                                                                @Parameter(hidden = true) PageRequest pageRequest) {
      return ResultResponse.of(ResultCode.GET_SIMILAR_PRODUCT_SUCCESS, productService.getRelatedById(id, pageRequest.of()));
   }

   @Operation( summary = "함께 구매하면 좋은 상품 3개 조회",
         description = "사용자가 상품을 찜한 경우, ✔️함께 구매하면 좋은 상품 3개✔️를 조회합니다.",
         parameters = { @Parameter(name = "productId", description = "상품 ID",
               in = ParameterIn.PATH, schema = @Schema(defaultValue = "1")) } )
   @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과 ➡️ SimilarProductGetResponse",
         content = @Content(schema = @Schema(implementation = SimilarProductGetResponse.class))) } )
   @GetMapping("/{productId}/recommend")
   public ResultResponse<List<SimilarProductGetResponse>> getRecommendedProductById(@PathVariable("productId") Long id) {
      return ResultResponse.of(ResultCode.GET_SIMILAR_PRODUCT_SUCCESS, productService.getRecommendedById(id));
   }
}
