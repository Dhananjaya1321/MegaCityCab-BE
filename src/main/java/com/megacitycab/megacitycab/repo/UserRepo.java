package com.megacitycab.megacitycab.repo;

import com.megacitycab.megacitycab.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u.email, u.username,u.password, u.role "+
            "FROM User u " +
            "where u.status!='DELETED' AND (u.email=:emailOrUsername OR u.username=:emailOrUsername)")
    Object searchUserByUsernameOrEmail(String emailOrUsername);

}
