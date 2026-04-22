package com.henson.song;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        // Frontend (Vite React)
                        .allowedOrigins(
                                "http://localhost:5173",
                                "https://song-ui-gl9x.onrender.com"
                        )

                        // IMPORTANT: add methods used by React apps
                        .allowedMethods(
                                "GET",
                                "POST",
                                "PUT",
                                "DELETE",
                                "PATCH",
                                "OPTIONS"
                        )

                        // Allow headers used by axios/fetch/auth
                        .allowedHeaders("*")

                        // IMPORTANT: allows cookies / JWT auth headers if needed
                        .allowCredentials(true)

                        // optional but useful for caching preflight requests
                        .maxAge(3600);
            }
        };
    }
}