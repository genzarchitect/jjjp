package com.stackroute.controller;


import com.stackroute.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.stackroute.Exceptions.EmailNotFound;
import com.stackroute.Exceptions.IncorrectPasswordException;
import com.stackroute.Exceptions.UserExistsException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.model.User;
import com.stackroute.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//@CrossOrigin("*")
@RestController
    @RequestMapping("/arena")
    public class LoginController {
    @Autowired
    private LoginService loginService;

//    @Autowired
//    private TokenGeneratorService tokenGeneratorService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    public ResponseEntity<?> responseEntity;

    @GetMapping("/welcome")
    public String welcome() {
        return "hello";
    }


//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserExistsException {
//        try {
//            User users = loginService.registerUser(user);
//            responseEntity = new ResponseEntity<>(users, HttpStatus.CREATED);
//        } catch (UserExistsException u) {
//            responseEntity = new ResponseEntity<>("User Already Exists.", HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserCredential credential) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUseremail(),credential.getPassword()));
            if (authenticate.isAuthenticated()) {
                String role = loginService.getUser(credential.getUseremail()).getName().toString();
                String jwt = jwtTokenUtil.generateToken(credential.getUseremail(), role);
                HashMap<String, String> token = new HashMap<>();
                token.put("token", jwt);
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                throw new RuntimeException("invalid access");
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
//        UserDetails userDetails = userDetailsService.loadUserByUsername(credential.getUseremail());




//        try {
//
//            // Log the request (simply printing to console for demonstration purposes)
//            System.out.println("Received login request for user: " + credential.getUseremail());
//
//            // Authenticate user
//            User user = loginService.authenticateUser(credential.getUseremail(), credential.getPassword());
//            //String token1 = jwtToken.generateToken(credential.getUseremail());
//
//            // Generate token
//            //Map<String, String> token = tokenGeneratorService.generateToken(credential);
//
//            // Log the successful authentication (printing to console)
//            System.out.println("Authentication successful for user: " + credential.getUseremail());
//
//            return new ResponseEntity<>(token1, HttpStatus.OK);
//        } catch (UserNotFoundException e) {
//            System.out.println("User not found: " + credential.getUseremail());
//            return new ResponseEntity<>("No user found with this email", HttpStatus.NOT_FOUND);
//        } catch (IncorrectPasswordException i) {
//            System.out.println("Incorrect password for user: " + credential.getUseremail());
//            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
//        }


    @PutMapping("/forget/{email}")
    public ResponseEntity<?> ForgotPassword(@PathVariable("email") String email, @RequestBody User user) {
        try {
            User userr = loginService.forgotPassword(email, user);
            responseEntity = new ResponseEntity<>(userr, HttpStatus.ACCEPTED);
        } catch (EmailNotFound e) {
            responseEntity = new ResponseEntity<>("Email not selected", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<?> getuser(@PathVariable String email){
        try {
            User userr = loginService.getUser(email);
            responseEntity = new ResponseEntity<>(userr, HttpStatus.ACCEPTED);
        } catch (EmailNotFound e) {
            responseEntity = new ResponseEntity<>("Email not selected", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

//    @KafkaListener(topics = "topic1", groupId = "groupone")
//    public void listen(String message) throws JsonProcessingException {
//        ObjectMapper user=new ObjectMapper();
//        User user2 =user.readValue(message,User.class);
//        log.info("Message received:{}", message);

}







