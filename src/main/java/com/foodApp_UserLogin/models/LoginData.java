package com.foodApp_UserLogin.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class LoginData {

    @Id
    @NotNull
    private Integer userId;

    private String userName;

    private String password;

}
