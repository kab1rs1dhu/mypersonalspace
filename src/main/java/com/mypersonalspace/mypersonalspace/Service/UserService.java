package com.mypersonalspace.mypersonalspace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypersonalspace.mypersonalspace.Models.User;
import com.mypersonalspace.mypersonalspace.Repositories.UserRepository;

@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepo;

    // here 12 is the strength of the encryption
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void registerUserToDB(User user){
        System.out.println("in registerUserToDB");
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        // first it will set the password to the encrypted password
        // then it will save the user to the database
    }

    public User authenticateUser(String username, String password){
        User user = userRepo.findByUsername(username);
        if(user == null){
            return null;
        }
        if(checkIfCorrectPassword(password, user.getPassword())){
            return user;
        }
        return null;
    }

    public boolean checkIfCorrectPassword(String rawPassword, String encodedPassword){
        System.out.println("rawPassword: " + rawPassword);
        System.out.println("encodedPassword: " + encodedPassword);
        return encoder.matches(rawPassword, encodedPassword);
    }

    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}