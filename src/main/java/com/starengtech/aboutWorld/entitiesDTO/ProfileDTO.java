package com.starengtech.aboutWorld.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.aboutWorld.entities.UserProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_profile")
public class ProfileDTO implements Serializable {
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

    public ProfileDTO() {
    }

    public ProfileDTO(UserProfile profile){
        this.name = profile.getName();
        this.email = profile.getEmail();
        this.password = profile.getPassword();
        this.country = profile.getCountry();
    }

    public ProfileDTO(String name, String email, String password, String nationality) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO profile = (ProfileDTO) o;
        return id.equals(profile.id) && email.equals(profile.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
