package services.teamSquads;

import com.fasterxml.jackson.databind.JsonNode;
import dao.players.PlayerDao;
import dao.teamSquads.TeamSquadDao;
import models.Player;
import models.TeamSquad;
import play.libs.Json;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class TeamSquadServiceImpl implements TeamSquadService {

    private TeamSquadDao teamSquadDao;
    private PlayerDao playerDao;

    @Inject
    public TeamSquadServiceImpl(TeamSquadDao teamSquadDao, PlayerDao playerDao) {
        this.teamSquadDao = teamSquadDao;
        this.playerDao = playerDao;
    }

    @Override
    public CompletionStage<Boolean> insertTeamSquad(TeamSquad teamSquad) {
        return teamSquadDao.insertTeamSquad(teamSquad);
    }

    @Override
    public CompletionStage<List<Player>> getPlayersForMatch(String country1, String country2) throws ExecutionException, InterruptedException {
        CompletionStage<List<TeamSquad>> squad = teamSquadDao.getPlayersForMatch(country1, country2);
        List<TeamSquad> teamSquads=  squad.toCompletableFuture().get();
        List<String> playersIds = new ArrayList<>();
        for (TeamSquad teamSquad : teamSquads) {
            Iterator<JsonNode> node = Json.parse(teamSquad.getPlayerIds()).elements();
            while (node.hasNext()) {
                playersIds.add(node.next().asText());
            }
        }

        return playerDao.getPlayers(country1, country2).thenApplyAsync(players -> {
            List<Player> p= players.stream().filter(player -> playersIds.contains(player.getPlayerId())).collect(Collectors.toList());
            return p;
        });
    }
}
