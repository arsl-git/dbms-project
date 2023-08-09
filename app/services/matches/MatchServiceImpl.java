package services.matches;

import dao.matches.MatchDao;
import dao.users.UserDao;
import models.Match;
import models.User;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class MatchServiceImpl implements MatchService {

    private MatchDao matchDao;

    @Inject
    public MatchServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public CompletionStage<Boolean> insertMatch(Match match) {
        return matchDao.insertMatch(match);
    }


    @Override
    public CompletionStage<Match> getMatchById(String matchId) {
        return matchDao.getMatchById(matchId);
    }

    @Override
    public CompletionStage<List<Match>> getAllMatches() {
        return matchDao.getAllMatches();
    }


}
