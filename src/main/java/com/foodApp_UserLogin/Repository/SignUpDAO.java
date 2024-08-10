package com.foodApp_UserLogin.Repository;

import com.foodApp_UserLogin.models.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpDAO extends JpaRepository<SignUp,Integer> {

    Optional<SignUp> findByUserName(String userName);

}
