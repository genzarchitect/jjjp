package com.stackroute.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String SECRET_KEY = "yoursecretkeyfhuiefheruiferfherifheruifheurifheruifhierfhuerifherifheruifierfherfierhrfher";

    // Extract username from the JWT
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Extract role as a single string
    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class); // Adjust "role" key as per your claim structure
    }

    // General method to extract all claims
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role) // Include role as a single string claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
