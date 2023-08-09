package services.contests;

import dao.contests.ContestDao;
import dao.users.UserDao;
import models.Contest;
import models.User;
import services.users.UserService;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class ContestServiceImpl implements ContestService {

        private ContestDao contestDao;

        @Inject
        public ContestServiceImpl(ContestDao contestDao) {
            this.contestDao = contestDao;
        }

        @Override
        public CompletionStage<Boolean> insertContest(Contest contest) {
            return contestDao.insertContest(contest);
        }

        @Override
        public CompletionStage<Contest> getContestById(String contestId) {
            return contestDao.getContestById(contestId);
        }

    @Override
    public CompletionStage<List<Contest>> getContestByMatchId(String matchId){
        return contestDao.getContestByMatchId(matchId);
    }

}
