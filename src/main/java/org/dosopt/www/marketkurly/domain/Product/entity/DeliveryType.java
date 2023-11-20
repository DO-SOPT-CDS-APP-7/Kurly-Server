package org.dosopt.www.marketkurly.domain.Product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryType {
   STANDARD("일반배송"),
   SAME_DAY("샛별배송")
   ;

   private final String delivery;
}
