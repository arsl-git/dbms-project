package services.teamSquads;

import com.google.inject.ImplementedBy;
import models.Player;
import models.TeamSquad;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

@ImplementedBy(TeamSquadServiceImpl.class)

public interface TeamSquadService {
    public CompletionStage<Boolean> insertTeamSquad(TeamSquad teamSquad);

    /**
     * @param country1
     * @param country2
     * @return
     */
    public CompletionStage<List<Player>> getPlayersForMatch(String country1, String country2) throws ExecutionException, InterruptedException;

}
