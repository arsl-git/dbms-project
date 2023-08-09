package dao.users;

import com.google.inject.ImplementedBy;
import models.User;

import java.util.concurrent.CompletionStage;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao {

    /**
     * insert user
     * @param user
     * @return
     */
    public CompletionStage<Boolean> insertUser(User user);

    /**
     *
     * @param userId
     * @return
     */
    public CompletionStage<User> getUserById(String userId);

    public CompletionStage<Boolean> checkIfValidLogin(String email, String password);

}
