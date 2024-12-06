package com.mypersonalspace.mypersonalspace.Models;

import java.util.List;

import com.mypersonalspace.mypersonalspace.Models.Helpers.Task;

public class User {

    private String name;
    private String email;
    private String password;
    private String age;
    private String typeOfMusic; // represents the type of music the user likes
    private List<String> favArtists; // would use this to store all the fav artists 
    private List<Task> tasks; // would use this to store all the tasks of the user

    public User(String name, String email, String password, String age, String typeOfMusic, List<String> favArtists,
            List<Task> tasks) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.typeOfMusic = typeOfMusic;
        this.favArtists = favArtists;
        this.tasks = tasks;
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

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public List<String> getFavArtists() {
        return favArtists;
    }

    public void setFavArtissts(List<String> favArtists) {
        this.favArtists = favArtists;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    
    
}
