package com.denis.storage.Models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Username cannot be empty.")
    private String username;
//    @Pattern(regexp = "((?=.*[A-Z]).{6,10})",message = "password must have an uppercase and should be between 6 and 10 characters")
    private String password;
    @Column(nullable = false)
    @NotEmpty(message = "FirstName cannot be empty.")
    private String firstname;
    @Column(nullable = false)
    @NotEmpty(message = "LastName cannot be empty.")
    private String lastname;
}