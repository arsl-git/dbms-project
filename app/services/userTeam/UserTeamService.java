package services.userTeam;

import com.google.inject.ImplementedBy;
import models.UserTeam;

import java.util.concurrent.CompletionStage;

@ImplementedBy(UserTeamServiceImpl.class)
public interface UserTeamService {


    /**
     * insert customer
     *
     * @param user
     * @return
     */
    public CompletionStage<Boolean> insertUserTeam(UserTeam userteam);

    /**
     * @param userId
     * @return
     */
    public CompletionStage<UserTeam> getUserTeamById(String userId);

}
