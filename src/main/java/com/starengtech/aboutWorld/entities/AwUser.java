package com.starengtech.aboutWorld.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_awuser")
public class AwUser implements Serializable {
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
    private String nationality;
    private String area;
    private String whats;
    private String instagram;
    private String photo;
    private boolean flActive;
    private boolean flLoggedIn;
    private boolean remote;

    @JsonIgnore
    @OneToMany(mappedBy = "awUser")
    private List<Adverts> adverts = new ArrayList<>();

    /*export type JobDetailsItem = {
        id: number;
        area: string;
        jobTitle: string;
        jobDescription: string;
        name: string;
        whats: string;
        instagram: string;
        nationality: string;
    };*/

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant lastLoginTime;

    //List<Role>: role
    //List<Adverts>: adverts
    //List<Doubts>: doubts
    //List<Tips>: tips

    public AwUser() {
    }

    public AwUser(Long id, String name, String email, String password, String nationality, String country, String area) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.nationality = nationality;
        this.flActive = true;
        this.area = area;
        this.remote=false;
    }

    public AwUser(Long id, String name, String email, String password, String nationality, String country, String area, boolean remote) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.nationality = nationality;
        this.flActive = true;
        this.area = area;
        this.remote=remote;
    }

    public AwUser(Long id, String name, String email, String password, String nationality, String country, String area, boolean remote, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.nationality = nationality;
        this.flActive = true;
        this.area = area;
        this.photo = photo;
        this.remote=remote;
    }

    public AwUser(Long id, String name, String email, String password, String nationality, String country, String area, boolean remote, String photo, String whats) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.nationality = nationality;
        this.whats = whats;
        this.flActive = true;
        this.area = area;
        this.photo = photo;
        this.remote=remote;
    }

    public AwUser(Long id, String name, String email, String password, String nationality, String country, String area, boolean remote, String photo, String whats, String instagram) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.nationality = nationality;
        this.whats = whats;
        this.instagram = instagram;
        this.photo = photo;
        this.flActive = true;
        this.area = area;
        this.remote=remote;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWhats() {
        return whats;
    }

    public void setWhats(String whats) {
        this.whats = whats;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwUser profile = (AwUser) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
