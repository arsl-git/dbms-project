package dao.users;

import models.User;
import models.DatabaseExecutionContext;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UserDaoImpl implements UserDao {

    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public UserDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertUser(User user) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection connection = db.getConnection();
                    String sql = "INSERT into user(userId, username, gender, email, phoneNo, usertype, userAddress, password) values(?,?,?,?,?,?,?,?)";
                    try {
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setString(1, user.generateUserId());
                        stmt.setString(2, user.getUsername());
                        stmt.setString(3, user.getGender());
                        stmt.setString(4, user.getEmail());
                        stmt.setString(5, user.getPhoneNo());
                        stmt.setString(6, user.getUsertype());
                        stmt.setString(7, user.getUserAddress());
                        stmt.setString(8, user.getPassword());
                        stmt.executeUpdate();
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return false;
                    }
                    return true;
                },
                executionContext);
    }

    public CompletionStage<User> getUserById(String userId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    User user = null;
                    Connection connection = db.getConnection();
                    String sql = "select * from user where userId ='" + userId + "'";
                    try {
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            user = new User(rs.getString("userId"),
                                    rs.getString("username"),
                                    rs.getString("gender"),
                                    rs.getString("email"),
                                    rs.getString("phoneNo"),
                                    rs.getString("usertype"),
                                    rs.getString("userAddress"),
                                    rs.getString("password"));
                        }
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return user;
                    }
                    // do whatever you need with the db connection
                    return user;
                },
                executionContext);
    }

    @Override
    public CompletionStage<Boolean> checkIfValidLogin(String email, String password) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    boolean isFound=false;
                    Connection connection = db.getConnection();
                    String sql = "select * from user where email ='" + email + "' and  password ='" + password + "'";
                    try {
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        if (rs.next())
                           isFound= true;
                        else
                           isFound= false;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return false;
                    }
                    return isFound;
                    // do whatever you need with the db connection
                },
                executionContext);
    }
}
