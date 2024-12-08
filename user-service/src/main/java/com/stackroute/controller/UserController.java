
package com.stackroute.controller;


import com.stackroute.exception.EmptyUserException;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
//@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    ResponseEntity<?> responseEntity;

    @GetMapping("/userList")
    public ResponseEntity<?> getUsers() {
        try{
            List<User> userList =  userService.getAllUsers();
            responseEntity = new ResponseEntity<>(userList, HttpStatus.OK);
        }
        catch (EmptyUserException e){
            responseEntity = new ResponseEntity<>("No User is Found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

//    @CrossOrigin(origins = "*")
    @PostMapping("/addUser")
    public ResponseEntity<?> addUsers(@RequestBody User user) throws UserAlreadyExistsException {
        try
        {
            User userList = userService.addUsersToDB(user);
            responseEntity = new ResponseEntity<>(userList, HttpStatus.CREATED);

        }
        catch (UserAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("User already present", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/userList/{userEmail}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("userEmail") String userEmail) {
        try{

            User userList =  userService.getUserByEmail(userEmail);
            responseEntity = new ResponseEntity<>(userList, HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            responseEntity = new ResponseEntity<>("No User is Found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/deleteUser/{userEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable("userEmail") String userEmail){
        try {
            boolean userDeleted = userService.deleteUser(userEmail);
            //if (!userService.deleteUser(userEmail)) {
                responseEntity = new ResponseEntity<>("userDeleted", HttpStatus.CREATED);

        }
        catch (UserNotFoundException e){
            responseEntity = new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/userList/{userEmail}")
    public ResponseEntity<?> updateUserByEmail(@PathVariable("userEmail") String userEmail, @RequestBody User user) {
        try{

            User userList =  userService.updateUserByEmail(userEmail,user);
            responseEntity = new ResponseEntity<>(userList, HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            responseEntity = new ResponseEntity<>("No User is Found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


}
