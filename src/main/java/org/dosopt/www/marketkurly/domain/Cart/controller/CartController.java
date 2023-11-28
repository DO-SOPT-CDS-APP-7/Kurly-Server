package org.dosopt.www.marketkurly.domain.Cart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Cart.dto.request.CartItemAddRequest;
import org.dosopt.www.marketkurly.domain.Cart.dto.response.CartItemGetResponse;
import org.dosopt.www.marketkurly.domain.Cart.service.CartService;
import org.dosopt.www.marketkurly.global.result.ResultCode;
import org.dosopt.www.marketkurly.global.result.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Tag(name = "CART cotroller", description = "장바구니 API입니다.")
public class CartController {
   private static final String CUSTOM_AUTH_ID = "X-Auth-id";
   private final CartService cartService;

   @Operation( summary = "장바구니 추가",
            description = "사용자가 상품을 장바구니에 추가합니다.",
            parameters = {@Parameter(name="productId", description = "상품 ID", in = ParameterIn.DEFAULT, schema = @Schema(defaultValue = "1")),
                          @Parameter(name="count", description = "상품 개수", in = ParameterIn.DEFAULT,  schema = @Schema(defaultValue = "1")),
                          @Parameter(name="X-Auth-id", description = "사용자 ID", in = ParameterIn.HEADER, schema = @Schema(defaultValue = "1"))})
    @PostMapping
    public ResultResponse createCart(@RequestHeader(CUSTOM_AUTH_ID) Long userId,
                                           @RequestBody CartItemAddRequest request){
        return ResultResponse.of(ResultCode.CREATE_CART_SUCCESS, cartService.addCart(request, userId));
    }


   @Operation( summary = "장바구니 조회",
            description = "사용자가 장바구니를 조회합니다.",
            parameters = {@Parameter(name="X-Auth-id", description = "장바구니 ID", in = ParameterIn.HEADER, schema = @Schema(defaultValue = "1"))})

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "성공 결과",
        content = @Content(schema = @Schema(implementation = CartItemGetResponse.class)))})
    @GetMapping
    public ResultResponse<List<CartItemGetResponse>> findCartItems(@RequestHeader(CUSTOM_AUTH_ID) Long cartId){
        return ResultResponse.of(ResultCode.GET_CARTITEMS_SUCCESS, cartService.findCartItems(cartId));
    }

    @Operation( summary = "장바구니 초기화",
            description = "사용자가 장바구니를 초기화합니다.",
            parameters = {@Parameter(name="X-Auth-id", description = "장바구니 ID", in = ParameterIn.HEADER, schema = @Schema(defaultValue = "1"))})
    @DeleteMapping
    public ResponseEntity<Void> deleteCartItems(@RequestHeader(CUSTOM_AUTH_ID) Long cartId) {
        cartService.deleteCartItems(cartId);
        return ResponseEntity.noContent().build();
    }


    @Operation( summary = "무료배송가격 조회",
            description = "사용자가 무료배송을 하기 위해 더 구매해야 할 상품의 가격을 알려줍니다.",
            parameters = {@Parameter(name="X-Auth-id", description = "장바구니 ID", in = ParameterIn.HEADER, schema = @Schema(defaultValue = "1"))})
    @GetMapping("/free-shipping")
    public ResultResponse<Integer> getFreeShippingPrice(@RequestHeader(CUSTOM_AUTH_ID) Long cartId){
        return ResultResponse.of(ResultCode.GET_FREESHIPPINGPRICE_SUCCESS, cartService.getFreeShippingPrice(cartId));
    }

}
