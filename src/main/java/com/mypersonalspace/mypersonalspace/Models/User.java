package com.mypersonalspace.mypersonalspace.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String email;
    private String password;
    private String age;
    private String username;

    public User() {
    }

    public User(String name, String email, String password, String age, String username) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.username = username;
    }

    public int getUid() {
        return uid;
    }   


    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

  
}
