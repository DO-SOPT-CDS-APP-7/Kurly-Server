package org.dosopt.www.marketkurly.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorizeRequests) ->
                  authorizeRequests.anyRequest().permitAll());
      return http.build();
   }

   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                  .allowedOrigins("*")
                  .allowedOriginPatterns("*")
                  .allowedMethods("*");
         }
      };
   }
}