package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Player;
import models.UserTeam;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.players.PlayerService;
import services.userTeam.UserTeamService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class UserTeamController extends Controller {
    private HttpExecutionContext ec;
    private UserTeamService userTeamService;

    @Inject
    public UserTeamController(UserTeamService UserTeamService, HttpExecutionContext ec) {
        this.userTeamService = userTeamService;
        this.ec = ec;
    }

    public CompletionStage<Result> insertUserTeam(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        UserTeam userTeam = Json.fromJson(json, UserTeam.class);

        return userTeamService.insertUserTeam(userTeam).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", x);
            result.put("data", x);
            return ok(result);

        });
    }

    public CompletionStage<Result> getUserTeamById(String userId) {

        return userTeamService.getUserTeamById(userId).thenApplyAsync(userTeam -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(userTeam));
            return ok(Json.toJson(result));
        });
    }

}
