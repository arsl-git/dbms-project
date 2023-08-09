package models;

import java.util.UUID;

public class Player {
    private String playerId;
    private String playerName;
    // private int userTeamId;
    private String playerType;
    private String country;
    public Player(){

    }

    public Player(String playerId, String playerName, String playerType, String country) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerType = playerType;
        this.country = country;
    }

    public Player(String playerName, String playerType, String country) {
        this.playerId = "player_" + System.currentTimeMillis();
        this.playerName = playerName;
        this.playerType = playerType;
        this.country = country;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String generatePlayerId() {
        return "Player_" + UUID.randomUUID();
    }

}
