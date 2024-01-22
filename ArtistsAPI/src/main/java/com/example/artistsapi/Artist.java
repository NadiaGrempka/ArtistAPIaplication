package com.example.artistsapi;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
@JsonIdentityInfo( // to jest po to zeby nie vbylo zapetlenia w relacji pomiedzy tytulami a artystami
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "artistId")
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @Column(name = "artist_id")
    private Long artistId;

    public String name;
    public String role;
    public  String nationality;
    @Column(name = "display_bio")
    public String displayBio;
    public String gender;
    @Column(name = "begin_date")
    public String beginDate;
    @Column(name = "end_date")
    public String endDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist", cascade = CascadeType.ALL)
    //@JsonManagedReference
//    @JsonIgnore
    public List<Title> titleList;

    public Artist(Long artistId, String name, String role, String nationality,String displayBio, String gender, String beginDate, String endDate) {
        this.artistId = artistId;
        this.name = name;
        this.role = role;
        this.nationality = nationality;
        this.displayBio = displayBio;
        this.gender = gender;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    protected Artist(){}

    public String setName(String name){
        return this.name = name;
    }
    public String getName(){
        return name;
    }

    public String setRole(String role){
        return this.role = role;
    }
    public String getRole(){
        return role;
    }

    public String setNationality(String nationality){
        return this.nationality = nationality;
    }
    public String getNationality(){
        return nationality;
    }

    public String setDisplayBio(String displayBio){
        return this.displayBio = displayBio;
    }
    public String getDisplayBio(){
        return displayBio;
    }

    public String setGender(String gender){
        return this.gender = gender;
    }
    public String getGender(){
        return gender;
    }

    public String setBeginDate(String beginDate){
        return this.beginDate = beginDate;
    }
    public String getBeginDate(){
        return beginDate;
    }

    public String setEndDate(String endDate){
        return this.endDate = endDate;
    }
    public String getEndDate(){
        return endDate;
    }

    public Long setArtistId(Long id) {
        return this.artistId = id;
    }

    public Long getArtistId() {
        return artistId;
    }

    public List<Title> getTitleList(){
        return titleList;
    }
    public List<Title> setTitleList(List<Title> titleList){
        return this.titleList = titleList;
    }

}
