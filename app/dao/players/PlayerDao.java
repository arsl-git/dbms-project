package dao.players;

import com.google.inject.ImplementedBy;
import models.Player;
import models.SelectedPlayers;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(PlayerDaoImpl.class)
public interface PlayerDao {


    /**
     *
     * @param player
     * @return
     */
    public CompletionStage<Boolean> insertPlayer(Player player);

    /**
     *
     * @param playerId
     * @return
     */
    public CompletionStage<Player> getPlayerById(String playerId);

    public CompletionStage<List<Player>> getPlayers(String country1, String country2);

    public CompletionStage<List<Player>> getSelectedPlayers(SelectedPlayers selectedPlayers);


}
