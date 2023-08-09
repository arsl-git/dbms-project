package services.contests;

import com.google.inject.ImplementedBy;
import models.Contest;
import models.UserTeam;
import services.userTeam.UserTeamServiceImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(ContestServiceImpl.class)

public interface ContestService {
    public CompletionStage<Boolean> insertContest(Contest contest);

    /**
     *
     * @param ContestId
     * @return
     */
    public CompletionStage<Contest> getContestById(String ContestId);

    /**
     *
     * @param matchId
     * @return
     */
    public CompletionStage<List<Contest>> getContestByMatchId(String matchId);

}
