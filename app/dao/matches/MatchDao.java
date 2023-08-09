package dao.matches;

import com.google.inject.ImplementedBy;
import models.Match;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(MatchDaoImpl.class)
public interface MatchDao {


    /**
     * insert user
     *
     * @param user
     * @return
     */
    public CompletionStage<Boolean> insertMatch(Match match);

    /**
     * @param userId
     * @return
     */
    public CompletionStage<Match> getMatchById(String matchId);

    public CompletionStage<List<Match>> getAllMatches();

}
