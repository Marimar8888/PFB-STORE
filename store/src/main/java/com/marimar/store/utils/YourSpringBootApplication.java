package com.marimar.store.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
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
}