package dao.teamSquads;

import com.google.inject.ImplementedBy;
import dao.users.UserDaoImpl;
import models.TeamSquad;
import models.User;

import java.util.List;
import java.util.concurrent.CompletionStage;
@ImplementedBy(TeamSquadDaoImpl.class)
public interface TeamSquadDao {

    public CompletionStage<Boolean> insertTeamSquad(TeamSquad teamSquad);

    /**
     *
     * @param userId
     * @return
     */
    public CompletionStage<List<TeamSquad>> getPlayersForMatch(String country1, String country2);


}
