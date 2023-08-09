package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.TeamSquad;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.teamSquads.TeamSquadService;


import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class TeamSquadController extends Controller {

    private HttpExecutionContext ec;
    private TeamSquadService teamSquadService;

    @Inject
    public TeamSquadController(TeamSquadService teamSquadService, HttpExecutionContext ec) {
        this.teamSquadService = teamSquadService;
        this.ec = ec;
    }

    public CompletionStage<Result> insertTeamSquad(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        TeamSquad teamSquad = Json.fromJson(json, TeamSquad.class);

        return teamSquadService.insertTeamSquad(teamSquad).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", x);
            result.put("data", x);
            return ok(result);

        });
    }

    public CompletionStage<Result> getPlayersForMatch(String country1, String country2) throws ExecutionException, InterruptedException {

        return teamSquadService.getPlayersForMatch(country1, country2).thenApplyAsync(teamSquad -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(teamSquad));
            return ok(Json.toJson(result));
        });
    }

}
