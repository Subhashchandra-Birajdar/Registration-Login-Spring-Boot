package com.foodApp_UserLogin.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users")
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;


    @NotNull
    @Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
    private String userName;

    @NotNull
    @Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
    private String password;

    @NotNull
    @Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
    private String mobileNo;

    //@Email
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$",message = "Invalid email address")
    @NotNull
    private String email;
}
