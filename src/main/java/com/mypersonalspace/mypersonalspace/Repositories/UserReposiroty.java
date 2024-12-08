package com.mypersonalspace.mypersonalspace.Repositories;
import com.mypersonalspace.mypersonalspace.Models.User;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
    List<User> findByEmail(String email);
    List<User> findByPassword(String password);
    User findByUsername(String username);
    
    
}
