package com.foodApp_UserLogin.Repository;

import com.foodApp_UserLogin.models.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentUserSessionDAO extends JpaRepository<CurrentUserSession,Integer> {

    Optional<CurrentUserSession> findByUserId(Integer userId);

    Optional<CurrentUserSession> findByUuid(String uuid);

}
