package com.starengtech.aboutWorld.entitiesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.AwUser;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class AdvertsDTO implements Serializable {
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

    public AdvertsDTO() {
    }

    public AdvertsDTO(Adverts ad){
        this.id= ad.getId();
        this.title= ad.getTitle();
        this.country=ad.getCountry();
        this.nationality=ad.getNationality();
        this.description= ad.getDescription();
        this.insertTime=ad.getInsertTime();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public String getCountry() {
        return country;
    }

    public String getNationality() {
        return nationality;
    }
}
