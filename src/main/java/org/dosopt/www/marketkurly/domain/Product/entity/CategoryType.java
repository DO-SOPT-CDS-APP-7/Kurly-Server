package org.dosopt.www.marketkurly.domain.Product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {
   VEGETABLES("채소"),
   FRUITS("과일/견과/쌀"),
   MEATS("정육/계란"),
   FISHERIES("수산/해산/건어물"),
   SALAD("샐러드/간편식"),
   NOODLES("면/양념/오일"),
   BEVERAGES("생수/음료/우유/커피"),
   BAKERY("베이커리/치즈/델리"),
   ALCOHOL("와인/위스키"),
   BEAUTY("스킨케어/메이크업"),
   KITCHEN_UTILS("주방용품")
   ;

   private final String categ;
}
