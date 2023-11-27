package org.dosopt.www.marketkurly.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@OpenAPIDefinition(
      info = @Info(title = "🚀[합동세미나 API 명세서]",
                  description = "Market Kurly API 명세서",
                  version = "v1"),
      servers = { @Server(url = "https://api.dosopt-kurly.store", description = "배포용"),
                  @Server(url = "http://localhost:8080", description = "로컬용") } )
@Configuration
public class SwaggerConfig {
}
