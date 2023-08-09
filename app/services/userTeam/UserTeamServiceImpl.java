package services.userTeam;

import dao.users.UserDao;
import dao.userteams.UserTeamDao;
import models.User;
import models.UserTeam;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class UserTeamServiceImpl implements UserTeamService{
    private UserTeamDao userTeamDao;

    @Inject
    public UserTeamServiceImpl(UserTeamDao userTeamDao) {
        this.userTeamDao = userTeamDao;
    }

    @Override
    public CompletionStage<Boolean> insertUserTeam(UserTeam userTeam) {
        return userTeamDao.insertUserTeam(userTeam);
    }

    @Override
    public CompletionStage<UserTeam> getUserTeamById(String userId) {
        return userTeamDao.getUserTeamById(userId);
    }

}
