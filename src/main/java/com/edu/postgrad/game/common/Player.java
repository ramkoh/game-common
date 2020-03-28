package com.edu.postgrad.game.common;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
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

@ApiModel(description = "Entity to hold player data")
@Entity
@Table(name = "players")
@Component
public class Player {
    @ApiModelProperty(notes = "Id of the player")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "First name of the player")
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty(notes = "Second name of the player")
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    @Column(name = "last_name")
    private String lastName;

    @ApiModelProperty(notes = "Jersey Number of the player")
    @Column(name = "jersey_number")
    @Positive
    private int jerseyNumber;

    @ApiModelProperty(notes = "Date of birth of the player")
    @Column( columnDefinition = "DATE")
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    @ApiModelProperty(notes = "Date of birth of the player")
    @Enumerated(EnumType.STRING)
    @Column(name = "player_position")
    private Position position;

    @ApiModelProperty(notes = "Team for which player is playing")
    @ManyToOne(targetEntity = Team.class) //TODO cascade: how is it workign without casecade?
    private Team team;

    @ApiModelProperty(notes = "Country in which player is born")
    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @ApiModelProperty(notes = "Age of the player")
    @Transient
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

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

}
