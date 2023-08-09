package models;

import scala.Array;

import java.util.List;
import java.util.UUID;

public class TeamSquad {
    private String squadId;
    private String squadName;
    private String playerIds;


    public TeamSquad() {

    }

    public TeamSquad(String squadId, String squadName, String playerIds) {
        this.squadId = squadId;
        this.squadName = squadName;
        this.playerIds = playerIds;

    }

    public TeamSquad(String squadName, String playerIds) {
        this.squadName = squadName;
        this.playerIds = playerIds;


    }


    public String getSquadId() {
        return squadId;
    }

    public void setSquadId(String squadId) {
        this.squadId = squadId;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(String playerIds) {
        this.playerIds = playerIds;
    }

    public String generaTeamSquadId() {
        return "Squad_" + UUID.randomUUID();
    }

}
