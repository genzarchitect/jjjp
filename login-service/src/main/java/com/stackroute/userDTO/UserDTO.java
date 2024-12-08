package com.stackroute.userDTO;


import com.stackroute.model.UserType;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserDTO {
    private String userEmail;
    private String userPassword;
    private UserType userType;
}