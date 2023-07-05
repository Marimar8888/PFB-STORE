package com.marimar.store.application.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private Long id;
    private String userName;
    private String password;
    // private String rol;

    public LoginDTO() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}