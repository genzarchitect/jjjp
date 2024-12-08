package com.stackroute.service;


import com.stackroute.model.User;
import com.stackroute.model.UserCredential;
import com.stackroute.repository.UserRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTToken{
    @Autowired
    UserRepo repo;

    @Value("${jwt.secret.key}")
    private String secretKey;

    public void validateToken(String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }


    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



//    @Override
//    public Map<String, String> generateToken(UserCredential credential) {
////        String token= Jwts.builder().setSubject(credential.getUseremail())
////                .setIssuer("Serviceused")
////                .setIssuedAt(new Date())
////                .signWith(SignatureAlgorithm.HS256,secretKey)
////                .compact();
//
//        String role = repo.findByEmail(credential.getUseremail()).get().getName().toString();
//
//        // Generate the JWT token
//        String token = Jwts.builder()
//                .setSubject(credential.getUseremail())  // Set the user email
//                .claim("role", role)                     // Add the role as a claim
//                .setIssuer("Serviceused")                // Set issuer
//                .setIssuedAt(new Date())                 // Set the issue date
//                .signWith(SignatureAlgorithm.HS256, secretKey) // Sign with the secret key
//                .compact();
//        return Map.of("token" ,token);
//    }


}
