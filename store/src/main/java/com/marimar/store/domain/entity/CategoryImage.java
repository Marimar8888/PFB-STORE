package com.marimar.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoryImages")
public class CategoryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryImagesSequence")
    @SequenceGenerator(name = "categoryImagesSequence")
    private Long id;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String title;

    @Lob
    private byte[] image;

    public CategoryImage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
