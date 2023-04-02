package com.starengtech.aboutWorld.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_profile")
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "email", nullable = false)
    private String email;
    private String password;
    private String country;
    private boolean flActive;
    private boolean flLoggedIn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant lastLoginTime;

    //List<Role>: role
    //List<Adverts>: adverts
    //List<Doubts>: doubts
    //List<Tips>: tips

    public UserProfile() {
    }

    public UserProfile(Long id, String name, String email, String password, String nationality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = nationality;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isFlActive() {
        return flActive;
    }

    public void setFlActive(boolean flActive) {
        this.flActive = flActive;
    }

    public boolean isFlLoggedIn() {
        return flLoggedIn;
    }

    public void setFlLoggedIn(boolean flLoggedIn) {
        this.flLoggedIn = flLoggedIn;
    }

    public Instant getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Instant lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile profile = (UserProfile) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
