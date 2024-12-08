package com.stackroute.repository;



import com.stackroute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User, String> {


    @Query("Select u from User u where u.useremail= :email AND u.password= :password")
    Optional<User> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);

    @Query("Select i from User i where i.useremail= :email")
    Optional<User> findByEmail(@Param("email") String email);
}