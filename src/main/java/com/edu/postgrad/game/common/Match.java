package com.edu.postgrad.game.common;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long team1;

    private Long team2;

    @Min(value = 3, message = "Location name cannot be smaller than 3 characters.")
    private String location;

    @Future
    private LocalDateTime dateTime;


    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeam1() {
        return team1;
    }

    public void setTeam1(Long team1) {
        this.team1 = team1;
    }

    public Long getTeam2() {
        return team2;
    }

    public void setTeam2(Long team2) {
        this.team2 = team2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


}
