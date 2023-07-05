package com.marimar.store.application.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private Long id;
    private String userName;

    public ClientDTO(Long id, String userName) { this.id = id; this.userName = userName;  }
    public Long getId() { return id;  }

    public void setId(Long id) { this.id = id;  }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}