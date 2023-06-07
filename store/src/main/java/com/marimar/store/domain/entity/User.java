package com.marimar.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
    private Long id;
    @Column(length = 15, nullable = false, unique = true)
    @Size(min = 3, max = 15)
    private String userName;
    @Column(length = 50, nullable = false)
    @Size(min = 3, max = 50)
    private String name;
    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String surNames;
    @Column(length = 12, nullable = false)
    @Size(min = 9, max = 12)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    @Size(min = 8)
    private String password;
    @Column(nullable = false)
    private String rol;

    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    Set<Item> favorites;

    public User() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurNames() {
        return surNames;
    }

    public void setSurNames(String surNames) {
        this.surNames = surNames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set<Item> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Item> favorites) {
        this.favorites = favorites;
    }
}
