package services.players;

import dao.players.PlayerDao;
import models.Player;
import models.SelectedPlayers;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class PlayerServiceImpl implements PlayerService {
    private PlayerDao playerDao;

    @Inject
    public PlayerServiceImpl(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Override
    public CompletionStage<Boolean> insertPlayer(Player player) {
        return playerDao.insertPlayer(player);
    }

    @Override
    public CompletionStage<Player> getPlayerById(String playerId) {
        return playerDao.getPlayerById(playerId);
    }

    @Override
    public CompletionStage<List<Player>> getPlayers(String country1, String country2) {
        return playerDao.getPlayers(country1, country2);
    }

    @Override
    public CompletionStage<List<Player>> getSelectedPlayers(SelectedPlayers selectedPlayers) {
        return playerDao.getSelectedPlayers(selectedPlayers);
    }


}
