package com.example.crm.config;

import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration; import org.springframework.web.cors.UrlBasedCorsConfigurationSource; import org.springframework.web.filter.CorsFilter;
import java.util.List;

@Configuration public class CorsCfg { @Bean public CorsFilter corsFilter(){ UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource(); CorsConfiguration c = new CorsConfiguration(); c.setAllowCredentials(true); c.setAllowedOrigins(List.of("http://localhost:5173","http://localhost:3000")); c.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS")); c.setAllowedHeaders(List.of("Authorization","Content-Type","X-Tenant-ID")); s.registerCorsConfiguration("/**", c); return new CorsFilter(s);} }
