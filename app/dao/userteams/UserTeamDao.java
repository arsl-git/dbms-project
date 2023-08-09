package dao.userteams;

import com.google.inject.ImplementedBy;
import dao.users.UserDaoImpl;
import models.User;
import models.UserTeam;

import java.util.concurrent.CompletionStage;
@ImplementedBy(UserTeamDaoImpl.class)
public interface UserTeamDao {



        /**
         * insert user
         * @param user
         * @return
         */
        public CompletionStage<Boolean> insertUserTeam(UserTeam userteam);

        /**
         *
         * @param userId
         * @return
         */
        public CompletionStage<UserTeam> getUserTeamById(String userId);



    }
