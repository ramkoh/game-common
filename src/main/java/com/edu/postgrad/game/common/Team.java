package com.edu.postgrad.game.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "team")
@ApiModel(description = "Model to hold team data")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id of the player")
    private Long id;

    @NotNull
    @ApiModelProperty(notes = "Name of the team")
    private String name;

    @Size(max = 3, message = "More than 3 characters are not allowed.")
    @NotNull
    @ApiModelProperty(notes = "Code name of the team")
    private String code;

    @ApiModelProperty(notes = "Website of the team")
    private String web;

    @Size(max = 11, message = "Team cannot have more than 11 players")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Player.class)
    @ApiModelProperty(notes = "Players playing for the team. Its a unidirectional mapping.")
    Collection<Player> players;

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

    public Collection<Player> getPlayers() {
        return players;
    }



    public void addPlayers(List<Player> players) {
        getPlayers().addAll(players);
    }

    public void removePlayer(Player player){
        players.remove(player);
        player.setTeam(null);
    }

}
