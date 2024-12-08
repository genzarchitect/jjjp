package com.stackroute.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(50)")
    private String useremail;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private UserType name;


}

