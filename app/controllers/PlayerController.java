package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Player;
import models.SelectedPlayers;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.players.PlayerService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class PlayerController extends Controller {
    private HttpExecutionContext ec;
    private PlayerService playerService;

    @Inject
    public PlayerController(PlayerService playerService, HttpExecutionContext ec) {
        this.playerService = playerService;
        this.ec = ec;
    }

    public CompletionStage<Result> insertPlayer(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        Player player = Json.fromJson(json, Player.class);

        return playerService.insertPlayer(player).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", x);
            result.put("data", x);
            return ok(result);

        });
    }

    public CompletionStage<Result> getPlayerById(String userId) {

        return playerService.getPlayerById(userId).thenApplyAsync(player -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(player));
            return ok(Json.toJson(result));
        });
    }

    public CompletionStage<Result> getPlayers(String country1, String country2) {
        int x = 10;
        return playerService.getPlayers(country1, country2).thenApplyAsync(players -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(players));
            return ok(Json.toJson(result));
        });
    }

    public CompletionStage<Result> getSelectedPlayers(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        SelectedPlayers players = Json.fromJson(json, SelectedPlayers.class);

        return playerService.getSelectedPlayers(players).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(x));
            return ok(result);

        });
    }
}
