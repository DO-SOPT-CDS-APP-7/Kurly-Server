package org.dosopt.www.marketkurly.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
      info = @Info(title = "🚀[합동세미나 API 명세서]",
               description = "Market Kurly API 명세서",
               version = "v1"))
@Configuration
public class SwaggerConfig {
}
