package com.example.artistsapi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
@JsonIdentityInfo( // to jest po to zeby nie vbylo zapetlenia w relacji pomiedzy tytulami a artystami
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "titleId")
@Entity
@Table(name = "title")
public class Title {
    @Id
    public Long titleId;
    public String objectName;
    public String title;
    public String culture;
    public String period;
    @ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    public Artist artist;
    public Long departmentId;

    public Title(Long titleId, String objectName, String title, String culture, String period, Long departmentId){
        this.titleId = titleId;
        this.objectName = objectName;
        this.title = title;
        this.culture = culture;
        this.period = period;
        this.departmentId = departmentId;
    }

    protected Title(){}

    public Long setTitleId(Long titleId) {
        return this.titleId = titleId;
    }
    public Long getTitleId() {
        return titleId;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getCulture() {
        return culture;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long setDepartmentId(Long departmentId) {
        return this.departmentId = departmentId;
    }

}
