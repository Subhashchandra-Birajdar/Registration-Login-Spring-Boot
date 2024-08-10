package com.foodApp_UserLogin.Repository;

import com.foodApp_UserLogin.models.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDataDAO extends JpaRepository<LoginData,Integer> {

}