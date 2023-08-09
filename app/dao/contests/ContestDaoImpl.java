package dao.contests;

import models.Contest;
import models.DatabaseExecutionContext;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ContestDaoImpl implements ContestDao {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public ContestDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertContest(Contest contest) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    String sql = "INSERT INTO contest( contestName,contestId,contestAmt,winningAmt,matchId,firstPrize,contestType)VALUES(?,?,?,?,?,?,?)";

                    try {


                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, contest.getContestName());
                        stmt.setString(2, contest.generateContestId());
                        stmt.setInt(3, contest.getContestAmt());
                        stmt.setLong(4, contest.getWinningAmt());
                        stmt.setString(5, contest.getMatchId());
                        stmt.setInt(6, contest.getFirstPrize());
                        stmt.setString(7, contest.getContestType());
                        stmt.executeUpdate();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        System.out.println("An exception occurred:" + throwables.getMessage());
                        return false;
                    }
                    return true;

                },
                executionContext);
    }

    public CompletionStage<Contest> getContestById(String contestId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Contest contest = null;
                    Connection con = db.getConnection();
                    String sql = "select * from contest where contestId ='" + contestId + "'";
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Contest contestObj = new Contest(rs.getString("contestName"),
                                    rs.getString("contestId"),
                                    rs.getInt("contestAmt"),
                                    rs.getLong("winningAmt"),
                                    rs.getString("matchId"),
                                    rs.getInt("firstPrize"),
                                    rs.getString("contestType"));

                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return contest;
                    }
                    // do whatever you need with the db connection
                    return contest;
                },
                executionContext);
    }

    @Override
    public CompletionStage<List<Contest>> getContestByMatchId(String matchId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    List<Contest> contests = new ArrayList<>();
                    Connection con = db.getConnection();
                    String sql = "select * from contest where matchId ='" + matchId + "'  order by winningAmt desc";
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Contest contestObj = new Contest(rs.getString("contestName"),
                                    rs.getString("contestId"),
                                    rs.getInt("contestAmt"),
                                    rs.getLong("winningAmt"),
                                    rs.getString("matchId"),
                                    rs.getInt("firstPrize"),
                                    rs.getString("contestType"));
                            contests.add(contestObj);

                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return contests;
                    }
                    // do whatever you need with the db connection
                    return contests;
                },
                executionContext);
    }

}
