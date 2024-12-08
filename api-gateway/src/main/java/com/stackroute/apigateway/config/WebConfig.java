package com.stackroute.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins to access the endpoints
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")  // You can specify your frontend URL here instead of "*"
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);  // Allow credentials if needed
    }
}