package com.chabiamin.restapidatabase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://192.168.1.100:41694")
                .allowedOrigins("*") // Allow requests from any origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD") // Allowed request methods
                .allowedHeaders("*") // Allowed headers
                .allowCredentials(false) // Allow credentials (cookies, authorization headers, etc.)
                .maxAge(3600); // Max age of the CORS pre-flight request
    }
}
