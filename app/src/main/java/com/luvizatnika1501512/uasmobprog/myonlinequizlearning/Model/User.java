package com.luvizatnika1501512.uasmobprog.myonlinequizlearning.Model;

public class User {

    private String nim;
    private String password;
    private String email;

    public User() {

    }

    public User(String nim, String password, String email){
        this.nim = nim;
        this.password = password;
        this.email = email;
    }

    public String getNim(){
        return nim;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
