package com.marimar.store.utils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{

    private final JwtConfig jwtConfig;

    public JwtTokenFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            try {
                Claims claims = Jwts.parser().setSigningKey(jwtConfig.getKey()).parseClaimsJws(token).getBody();
                username = claims.getSubject();
            } catch (ExpiredJwtException e) {
                // Token has expired
            } catch (Exception e) {
                // Token is not valid
            }
        }

        if (username != null) {
            // Token is valid, set the authentication in the SecurityContext
            // You can also implement your own authentication mechanism if needed
            // For simplicity, this example just sets the username in the request attribute
            request.setAttribute("username", username);
        }

        filterChain.doFilter(request, response);
    }
}
