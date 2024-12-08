package com.stackroute.apigateway.config;

import com.stackroute.apigateway.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    public JwtAuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Retrieve the JWT from the header
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Mono.error(new RuntimeException("Missing or invalid Authorization header"));
            }

            String token = authHeader.substring(7); // Remove "Bearer " prefix

            // Validate and parse the JWT token
            if (!jwtTokenUtil.validateToken(token)) {
                return Mono.error(new RuntimeException("Invalid JWT token"));
            }

            // Set the authentication in the SecurityContext
            String username = jwtTokenUtil.extractUsername(token);
            String role = jwtTokenUtil.extractRole(token);  // Assuming role is in token claims

            // Create an authentication object and set it in the SecurityContext
            List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
            var authentication = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Proceed to the next filter in the chain
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Add any configuration if needed
    }
}