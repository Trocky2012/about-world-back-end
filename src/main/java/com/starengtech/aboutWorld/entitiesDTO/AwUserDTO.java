package com.starengtech.aboutWorld.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.aboutWorld.entities.AwUser;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class AwUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String country;
    private String nationality;
    private String area;
    private String whats;
    private String instagram;
    private String photo;
    private boolean flActive;
    private boolean flLoggedIn;
    private boolean remote;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant lastLoginTime;

    public AwUserDTO() {
    }

    public AwUserDTO(AwUser awUser){
        this.id=awUser.getId();
        this.name = awUser.getName();
        this.email = awUser.getEmail();
        this.password = awUser.getPassword();
        this.country = awUser.getCountry();
        this.nationality=awUser.getNationality();
        this.area= awUser.getArea();
        this.whats=awUser.getWhats();
        this.instagram=awUser.getInstagram();
        this.photo=awUser.getPhoto();
        this.flActive = awUser.isFlActive();
        this.flLoggedIn = awUser.isFlLoggedIn();
        this.remote = awUser.isRemote();
    }

    public AwUserDTO(String name, String email, String password, String nationality) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = nationality;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public boolean isFlActive() {
        return flActive;
    }

    public boolean isFlLoggedIn() {
        return flLoggedIn;
    }

    public Instant getLastLoginTime() {
        return lastLoginTime;
    }

    public String getNationality() {
        return nationality;
    }

    public String getArea() {
        return area;
    }

    public String getWhats() {
        return whats;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getPhoto() {
        return photo;
    }

    public boolean isRemote() {
        return remote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwUserDTO profile = (AwUserDTO) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
