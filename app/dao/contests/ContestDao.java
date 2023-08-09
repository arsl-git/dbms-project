package dao.contests;

import com.google.inject.ImplementedBy;
import dao.users.UserDaoImpl;
import models.Contest;
import models.User;

import java.util.List;
import java.util.concurrent.CompletionStage;
@ImplementedBy(ContestDaoImpl.class)
public interface ContestDao {

    public CompletionStage<Boolean> insertContest(Contest contest);

    /**
     *
     * @param userId
     * @return
     */
    public CompletionStage<Contest> getContestById(String ContestId);

    public CompletionStage<List<Contest>> getContestByMatchId(String matchId);

}
