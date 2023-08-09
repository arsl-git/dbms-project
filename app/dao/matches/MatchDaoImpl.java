package dao.matches;


import dao.matches.MatchDao;
import models.DatabaseExecutionContext;
import models.Match;
import models.User;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class MatchDaoImpl implements MatchDao {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public MatchDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertMatch(Match match) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    String sql = "INSERT INTO matches(matchId,matchName,matchDate,squadId1,squadId2,country1,country2)VALUES(?,?,?,?,?,?,?)";

                    try {
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, match.generateMatchId());
                        stmt.setString(2, match.getMatchName());
                        stmt.setString(3, match.getMatchDate());
                        stmt.setString(4, match.getSquadId1());
                        stmt.setString(5, match.getSquadId2());
                        stmt.setString(6, match.getCountry1());
                        stmt.setString(7, match.getCountry2());
                        stmt.executeUpdate();
                        stmt.close();
                        con.close();


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return false;
                    }
                    return true;
                },
                executionContext);
    }

    public CompletionStage<Match> getMatchById(String matchId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Match match = null;
                    Connection connection = db.getConnection();
                    String sql = "select * from matches where matchId ='" + matchId + "'";
                    try {
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            match = new Match(rs.getString("matchId"),
                                    rs.getString("matchName"),
                                    rs.getString("matchDate"),
                                    rs.getString("squadId1"),
                                    rs.getString("squadId2"),
                                    rs.getString("country1"),
                                    rs.getString("country2"));


                        }
                        rs.close();
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return match;
                    }
                    // do whatever you need with the db connection
                    return match;
                },
                executionContext);
    }

    @Override
    public CompletionStage<List<Match>> getAllMatches() {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    List<Match> matches = new ArrayList<>();
                    Connection connection = db.getConnection();
                    String sql = "select * from matches";
                    try {
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Match match = new Match(
                                    rs.getString("matchId"),
                                    rs.getString("matchName"),
                                    rs.getString("matchDate"),
                                    rs.getString("squadId1"),
                                    rs.getString("squadId2"),
                                    rs.getString("country1"),
                                    rs.getString("country2"));
                            matches.add(match);

                        }
                        rs.close();
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return matches;
                    }
                    // do whatever you need with the db connection
                    return matches;
                },
                executionContext);
    }
}
