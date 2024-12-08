package com.stackroute.service;


import com.stackroute.Exceptions.EmailNotFound;
import com.stackroute.Exceptions.IncorrectPasswordException;
import com.stackroute.Exceptions.UserExistsException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.repository.UserRepo;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceimp implements LoginService {

    @Autowired
    UserRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) throws UserExistsException {
        boolean existby= repo.existsById(user.getUseremail());
        if (existby) {
            throw new UserExistsException("User already");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.repo.save(user);
    }
@Override
    public User authenticateUser(String email, String password) throws UserNotFoundException, IncorrectPasswordException {
        boolean exist= repo.existsById(email);
        if (!exist) {
            throw new UserNotFoundException(" User does not exist with given email");
        }
        Optional<User> optUser = repo.findByEmailAndPassword(email, password);
        if (optUser.isEmpty()) {
            throw new IncorrectPasswordException("Password missing");
        }
        return optUser.get();

    }

    @Override
    public User getUser(String email) throws UserNotFoundException {
        boolean exist= repo.existsById(email);
        if (!exist) {
            throw new UserNotFoundException(" User does not exist with given email");
        }
        return repo.findByEmail(email).get();
    }

    @Override
    public User forgotPassword(String email, User user) throws EmailNotFound {
            Optional<User> opt = repo.findByEmail(email);

            if (opt.isPresent()) {
                User users = opt.get();

                users.setPassword(user.getPassword());

                repo.save(users);
                return users;

            }else {
                throw new EmailNotFound("EmailNotFound");
            }
        }
}