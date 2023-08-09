package services.users;

import com.google.inject.ImplementedBy;
import models.Login;
import models.User;

import java.util.concurrent.CompletionStage;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    /**
     * insert customer
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

    public CompletionStage<Boolean> checkIfValidLogin(Login login);

}
