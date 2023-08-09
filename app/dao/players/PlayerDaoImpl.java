package dao.players;

import models.DatabaseExecutionContext;
import models.Player;
import models.SelectedPlayers;
import models.User;
import play.db.Database;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class PlayerDaoImpl implements PlayerDao {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public PlayerDaoImpl(Database db, DatabaseExecutionContext executionContext) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Boolean> insertPlayer(Player player) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    String sql = "INSERT INTO player(playerId,playerName, playerType,country)VALUES(?,?,?,?)";

                    try {
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, player.generatePlayerId());
                        stmt.setString(2, player.getPlayerName());
                        stmt.setString(3, player.getPlayerType());

                        stmt.setString(4, player.getCountry());

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

    public CompletionStage<Player> getPlayerById(String playerId) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Player player = null;
                    Connection con = db.getConnection();
                    String sql = "select * from player where playerId ='" + playerId + "'";
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Player playerObj = new Player(rs.getString("playerId"),
                                    rs.getString("playerName"),
                                    rs.getString("playerType"),
                                    rs.getString("country"));


                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return player;
                    }
                    // do whatever you need with the db connection
                    return player;
                },
                executionContext);
    }

    @Override
    public CompletionStage<List<Player>> getPlayers(String country1, String country2) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    List<Player> players = new ArrayList<>();
                    String sql = "select * from player where country ='" + country1 + "' or country ='" + country2 + "'";
                    try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            Player playerObj = new Player(rs.getString("playerId"),
                                    rs.getString("playerName"),
                                    rs.getString("playerType"),
                                    rs.getString("country"));
                            players.add(playerObj);
                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return players;
                    }
                    // do whatever you need with the db connection
                    return players;
                },
                executionContext);
    }

    @Override
    public CompletionStage<List<Player>> getSelectedPlayers(SelectedPlayers selectedPlayers) {
        return CompletableFuture.supplyAsync(
                () -> {
                    // get jdbc connection
                    Connection con = db.getConnection();
                    List<Player> players = new ArrayList<>();
                    List<String> playerIds = selectedPlayers.getPlayerIds();
                    String query = "SELECT * FROM player WHERE playerId IN (";
                    for (int i = 0; i < playerIds.size(); i++) {
                        if (i == playerIds.size() - 1) {
                            query = query + "?";
                        } else {
                            query = query + "?,";
                        }
                    }
                    query = query + ")";
                    try {
                        PreparedStatement statement = con.prepareStatement(query);
                        for (int i = 0; i < playerIds.size(); i++) {
                            statement.setString(i + 1, playerIds.get(i));
                        }
                        ResultSet rs = statement.executeQuery();
                        while (rs.next()) {
                            Player playerObj = new Player(rs.getString("playerId"),
                                    rs.getString("playerName"),
                                    rs.getString("playerType"),
                                    rs.getString("country"));
                            players.add(playerObj);
                        }
                        rs.close();
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return players;
                    }
                    // do whatever you need with the db connection
                    return players;
                },
                executionContext);
    }


}
