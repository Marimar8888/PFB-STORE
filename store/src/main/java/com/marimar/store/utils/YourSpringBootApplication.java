package com.marimar.store.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

public class YourSpringBootApplication {
    private final JwtConfig jwtConfig;
    @Autowired
    public YourSpringBootApplication(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(YourSpringBootApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<JwtTokenFilter> jwtTokenFilter() {
        FilterRegistrationBean<JwtTokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtTokenFilter(jwtConfig));
        // Add the endpoint(s) you want to protect. In this case, all endpoints are protected
        registrationBean.addUrlPatterns("/api/*"); // Change this to match your endpoint patterns
        return registrationBean;
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        // Allow access to H2 console path
        configuration.addExposedHeader("Access-Control-Allow-Origin");
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("DELETE");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}