package com.edu.postgrad.game.common;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teams_players")
public class TeamsPlayers {
    private Long teamId;
    private Long playerId;
}
