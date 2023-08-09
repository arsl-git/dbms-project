package dao.teamSquads;

import models.DatabaseExecutionContext;
import models.Player;
import models.TeamSquad;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TeamSquadDaoImpl implements TeamSquadDao {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public TeamSquadDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertTeamSquad(TeamSquad teamSquad) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    String sql = "INSERT INTO teamSquad(squadId,squadName,playerIds)VALUES(?,?,?)";

                    try {

                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, teamSquad.generaTeamSquadId());
                        stmt.setString(2, teamSquad.getSquadName());
                        stmt.setString(3, teamSquad.getPlayerIds());
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

    public CompletionStage<List<TeamSquad>> getPlayersForMatch(String country1, String country2) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    List<TeamSquad> teamSquads = new ArrayList<>();
                    Connection con = db.getConnection();
                    String sql = "select * from teamSquad where squadName ='" + country1 + "' or squadName ='" + country2 + "'";
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                           TeamSquad teamSquadObj = new TeamSquad(rs.getString("squadId"),
                                    rs.getString("squadName"),
                                    rs.getString("playerIds"));
                           teamSquads.add(teamSquadObj);
                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return teamSquads;
                    }
                    // do whatever you need with the db connection
                    return teamSquads;
                },
                executionContext);
    }



}
