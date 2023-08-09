package services.users;

import dao.users.UserDao;
import models.Login;
import models.User;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Inject
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CompletionStage<Boolean> insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public CompletionStage<User> getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public CompletionStage<Boolean> checkIfValidLogin(Login login) {
        return userDao.checkIfValidLogin(login.getEmail(), login.getPassword());
    }
}
