package org.dosopt.www.marketkurly.domain.Product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubCategoryType {
   // vegetables
   SWEET_POTATO_CARROT("고구마/감자/당근"),
   BROCOLLI_PAPRIKA_CABBAGE("브로콜리/파프리카/양배추"),
   ONION_GARLIC("마늘/양파"),

   // fruits
   SEASONAL_FRUITS("제철과일"),
   DOMESTIC_FRUITS("국산과일"),
   FROZEN_DRIED_FRUITS("냉동/건과일"),

   // meats
   PORK("돼지고기"),
   DOMESTIC_BEEF("국내산 소고기"),
   EGGS("계란류"),

   // fisheries
   SHRIMP_CRAB_LOBSTER("새우/게/랍스터"),
   SQUID_OCTOPUS("오징어/문어"),
   SEAWEED("김/미역/해조류"),
   FISH("생선류"),

   // salad
   SALAD("샐러드/닭가슴살"),
   LUNCH_RICE("도시락/밥류"),
   CEREAL("시리얼"),

   // noodles
   PASTA_NOODLES("파스타/면류"),
   SALT_SUGAR_SPICES("소금/설탕/향신료"),
   FLOUR_POWDER_MIX("밀가루/가루/믹스")
   ;

   private final String subCateg;
}
