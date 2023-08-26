package com.marimar.store.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "carouselimages")
public class Carousel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carouselSequence")
    @SequenceGenerator(name = "carouselSequence")
    private Long id;

    @Lob
    private byte[] image;

    @Column
    private boolean active;

    public Carousel() {
    }

    public Long getId() {
        return id;
    }

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
