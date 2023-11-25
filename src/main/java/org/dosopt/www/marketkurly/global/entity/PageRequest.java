package org.dosopt.www.marketkurly.global.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;

public final class PageRequest {
   @Schema(description = "페이지")
   private int page;
   @Schema(description = "사이즈")
   private int size;
   @Schema(description = "오름차순(ASC)/내림차순(DESC)")
   private Sort.Direction direction = Sort.Direction.DESC;

   public void setPage(int page) {
      this.page = page <= 0 ? 1 : page;
   }

   public void setSize(int size) {
      int DEFAULT_SIZE = 10;
      int MAX_SIZE = 50;
      this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
   }

   public void setDirection(Sort.Direction direction) {
      this.direction = direction;
   }

   public Pageable of() {
      return (Pageable) org.springframework.data.domain.PageRequest.of(page -1, size, direction, "updatedAt");
   }
}
