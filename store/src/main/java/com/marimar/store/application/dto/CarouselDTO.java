package com.marimar.store.application.dto;

import java.io.Serializable;

public class CarouselDTO implements Serializable {

    private Long id;
    private byte[] image;

    private boolean active;

    public CarouselDTO() {
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
