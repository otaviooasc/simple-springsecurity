package com.spring.jwt.spring.security.security;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Value("${security.config.prefix}")
    private String prefix;

    @Value("${security.config.key}")
    private String key;

    @Value("${security.config.expiration}")
    private Long expiration;

    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    @PostConstruct
    public void init() {
        PREFIX = prefix;
        KEY = key;
        EXPIRATION = expiration;
    }
}
