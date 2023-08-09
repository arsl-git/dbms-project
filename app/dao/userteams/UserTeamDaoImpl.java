package dao.userteams;

import models.DatabaseExecutionContext;
import models.User;
import models.UserTeam;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UserTeamDaoImpl implements UserTeamDao {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public UserTeamDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertUserTeam(UserTeam userteam) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection connection = db.getConnection();


                        String sql = "INSERT INTO UserTeam(userTeamId,userId,playerId)VALUES(?,?,?)";

                        try {
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setString(2,userteam.getUserTeamId());
                        stmt.setString(3,userteam.getUserId());
                        stmt.setString(4,userteam.getPlayerId());
                        stmt.executeUpdate();
                        stmt.close();

                    }  catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return false;
                    }
                    return true;
                },
                executionContext);
    }

    public CompletionStage<UserTeam> getUserTeamById(String userId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    UserTeam userTeam = null;
                    Connection connection = db.getConnection();
                    String sql = "select * from userTeam where userId ='" + userId + "'";
                    try {
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            UserTeam userTeamObj=new UserTeam(


                                   rs.getString("userTeamId"),
                                    rs.getString("userId"),
                                    rs.getString("playerId"));



                        }
                        rs.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return userTeam;
                    }
                    // do whatever you need with the db connection
                    return userTeam;
                },
                executionContext);
    }

}
