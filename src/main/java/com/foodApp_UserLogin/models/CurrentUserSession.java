package com.foodApp_UserLogin.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true)
    private Integer userId;

    private String uuid;

    private LocalDateTime localDateTime;

    public CurrentUserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
        super();
        this.userId = userId;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }

}
