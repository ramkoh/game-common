package com.edu.postgrad.game.common;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "players")
@Component
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the player")
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    @Column(name = "first_name")
    @ApiModelProperty(notes = "First name of the player")
    private String firstName;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    @Column(name = "last_name")
    @ApiModelProperty(notes = "Second name of the player")
    private String lastName;

    @Column(name = "jersey_number")
    @Positive
    @ApiModelProperty(notes = "Jersey Number of the player")
    private int jerseyNumber;

    @Column( columnDefinition = "DATE")
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(notes = "Date of birth of the player")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_position")
    @ApiModelProperty(notes = "Date of birth of the player")
    private Position position;

    @ManyToOne(targetEntity = Team.class) //TODO cascade: how is it workign without casecade?
    @ApiModelProperty(notes = "Team for which player is playing")
    private Team team;

    @Transient
    @ApiModelProperty(notes = "Age of the player")
    private int age;

    public Player(){
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
