package com.edu.postgrad.game.common;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the player")
    private Long id;

    @ApiModelProperty(notes = "Name of the team")
    private String name;

    @Size(max = 3, message = "More than 3 characters are not allowed.")
    @ApiModelProperty(notes = "Code name of the team")
    private String code;

    @ApiModelProperty(notes = "Website of the team")
    private String web;

    @Size(min = 1, message = "Team must have at least 1 player.")
    @OneToMany(targetEntity = Player.class/*, fetch = FetchType.LAZY*/) //Could not write JSON: failed to lazily initialize a collection of role: com.edu.postgrad.game.common
    @ApiModelProperty(notes = "Players playing for the team")
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(List<Player> players) {
        getPlayers().addAll(players);
    }

    public void addPlayer(Player player) {
        getPlayers().add(player);
    }

}
