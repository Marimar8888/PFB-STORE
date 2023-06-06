package com.marimar.store.application.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String userName;
    private String password;
    // private String rol;

    public LoginDTO() {
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

  /*  public String getRol() {
        return rol;
    }

    //public void setRol(String rol) {
        this.rol = rol;
    }*/
}