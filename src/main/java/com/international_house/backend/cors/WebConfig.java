package com.international_house.backend.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://10.0.2.2:8080", "http://172.18.31.158:3000") // Allow
                                                                                                                      // specific
                                                                                                                      // origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow specific HTTP methods
            }
        };
    }
}
