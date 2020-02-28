package com.edu.postgrad.game.common;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String representsState;

    @Size(min = 1, message = "Team must have at least 1 player.")
    @OneToMany(targetEntity = Player.class)
    List<Player> players;

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

    public String getRepresentsState() {
        return representsState;
    }

    public void setRepresentsState(String representsState) {
        this.representsState = representsState;
    }

}
