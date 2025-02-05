package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Enable CORS for all API endpoints
        registry.addMapping("/**")  // Apply to all routes
                .allowedOrigins("http://localhost:3000")  // Allow requests from the front-end (port 3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow only these HTTP methods
                .allowedHeaders("*");  // Allow all headers
    }
}