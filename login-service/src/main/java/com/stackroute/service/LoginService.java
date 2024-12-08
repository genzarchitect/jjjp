package com.stackroute.service;

import com.stackroute.Exceptions.EmailNotFound;
import com.stackroute.Exceptions.IncorrectPasswordException;
import com.stackroute.Exceptions.UserExistsException;
import com.stackroute.Exceptions.UserNotFoundException;

import com.stackroute.model.User;

public interface LoginService {

    User registerUser(User user)throws UserExistsException;
    User authenticateUser(String email,String password) throws UserNotFoundException, IncorrectPasswordException;
    User getUser(String email) throws UserNotFoundException;
    User forgotPassword(String email,User user)throws EmailNotFound;


}
