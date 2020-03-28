package com.edu.postgrad.game.common;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "matches")
@ApiModel(description = "Model to hold match data")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the match")
    private Long id;

    @ApiModelProperty(notes = "Team 1 playing the match")
    private String team1;

    @ApiModelProperty(notes = "Team 2 playing the match")
    private String team2;

    @Size(min = 3, message = "Location name cannot be smaller than 3 characters")
    @ApiModelProperty(notes = "Location where match is being played")
    private String location;

    @Column( columnDefinition = "DATE", name = "match_date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    @ApiModelProperty(notes = "Date and time when match will be played")
    private LocalDateTime matchDateTime;


    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(LocalDateTime matchDateTime) {
        this.matchDateTime = matchDateTime;
    }
}
