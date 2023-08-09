package models;

import java.util.List;

public class SelectedPlayers {

    private List<String> playerIds;

    public SelectedPlayers(){

    }
    public SelectedPlayers(List<String> playerIds) {
        this.playerIds = playerIds;
    }

    public List<String> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<String> playerIds) {
        this.playerIds = playerIds;
    }
}
