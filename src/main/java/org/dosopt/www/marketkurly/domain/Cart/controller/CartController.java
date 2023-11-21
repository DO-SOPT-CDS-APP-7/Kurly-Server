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
import org.dosopt.www.marketkurly.domain.Cart.service.CartService;
import org.dosopt.www.marketkurly.domain.Product.dto.response.ProductGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Tag(name = "CART cotroller", description = "장바구니 API입니다.")
public class CartController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-id";
    private final CartService cartService;

    @Operation( summary = "장바구니 추가",
            description = "사용자가 상품을 장바구니에 추가합니다.")
    @PostMapping
    public ResponseEntity<Void> createCart(@RequestHeader(CUSTOM_AUTH_ID) Long userId,
                                           @RequestBody CartItemAddRequest request){
        cartService.addCart(request, userId);
        URI location = URI.create("/cart");
        return ResponseEntity.created(location).build();
    }

}
