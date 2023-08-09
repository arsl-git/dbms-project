package services.matches;

import com.google.inject.ImplementedBy;
import models.Match;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(MatchServiceImpl.class)

public interface MatchService {


    public CompletionStage<Boolean> insertMatch(Match match);

    public CompletionStage<Match> getMatchById(String matchId);

    public CompletionStage<List<Match>> getAllMatches();

}
