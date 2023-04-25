package com.starengtech.aboutWorld.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.aboutWorld.entitiesDTO.AdvertsDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_awadverts")
public class Adverts implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String country;
    private String nationality;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "Canada/Atlantic")
    private Instant insertTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AwUser awUser;

    public Adverts() {
    }

    public Adverts(Long id, String title, String description, AwUser awUser) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.awUser=awUser;
        this.country= awUser.getCountry();
        this.nationality= awUser.getNationality();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AwUser getAwUser() {
        return awUser;
    }

    public void setAwUser(AwUser awUser) {
        this.awUser = awUser;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adverts adverts = (Adverts) o;
        return Objects.equals(id, adverts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
