package models;

import java.util.List;
import java.util.UUID;

public class UserTeam {
    private String userTeamId;
    private String userId;
    private String playerId;

    public UserTeam() {

    }

    public UserTeam(String userTeamId, String userId, String playerId) {
        this.userTeamId = userTeamId;
        this.userId = userId;
        this.playerId = playerId;
    }

    public UserTeam(String userTeamId, String playerId) {
        this.userTeamId = userTeamId;
        this.playerId = playerId;
    }

    public String getUserTeamId() {
        return userTeamId;
    }

    public void setUserTeamId(String userTeamId) {
        this.userTeamId = userTeamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String generateUserId() {
        return "user_" + UUID.randomUUID();
    }
}
