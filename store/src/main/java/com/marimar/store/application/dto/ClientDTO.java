package com.marimar.store.application.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private Long id;
    private String userName;
    private String token;

    public ClientDTO(Long id, String userName, String token) { this.id = id; this.userName = userName; this.token = token; }
    public Long getId() { return id;  }

    public void setId(Long id) { this.id = id;  }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}