package com.marimar.store.application.dto;

import java.io.Serializable;

public class ItemShopDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer reduced;
    private byte[] image;


    public ItemShopDTO() {     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getReduced() { return reduced;   }

    public void setReduced(Integer reduced) {
        this.reduced = reduced;
    }
}
