//package com.stackroute.groundservice;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/player/**").hasRole("PLAYER")  // Only PLAYER role can access /player/**
//                .antMatchers("/owner/**").hasRole("OWNER")    // Only OWNER role can access /owner/**
//                .anyRequest().authenticated()  // All other requests must be authenticated
//                .and()
//                .httpBasic().disable();  // Disable HTTP Basic Auth as you are using JWT
//    }
//}
