package com.marimar.store.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.jwt")
public class JwtConfig {

    // Inyecta estas claves desde tu application.yml o application.properties
    @Value("${spring.jwt.secret}")
    private String secret;
    @Value("${spring.jwt.expiration}")
    private int expiration;
    // Usa esta variable para almacenar la clave secreta generada por Keys.secretKeyFor()
    private Key key;
    public JwtConfig() {
        // Genera una clave secreta al inicializar el objeto
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String generateToken(String username) {
        // Verifica que jwtConfig no sea null
        if (secret == null) {
            throw new RuntimeException("Error: La clave secreta no está configurada.");
        }

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key) // Usa la clave secreta generada
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();    }
}