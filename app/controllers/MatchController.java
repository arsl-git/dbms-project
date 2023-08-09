package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Login;
import models.Match;
import models.User;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.matches.MatchService;
import services.users.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class MatchController extends Controller {

        private HttpExecutionContext ec;
        private MatchService matchService;

        @Inject
        public MatchController(MatchService matchService, HttpExecutionContext ec) {
            this.matchService = matchService;
            this.ec = ec;
        }

        public CompletionStage<Result> insertMatch(Http.Request request) {
            //requested jon from post request
            JsonNode json = request.body().asJson();
            // convert json to user class/object
            Match match = Json.fromJson(json, Match.class);

            return matchService.insertMatch(match).thenApplyAsync(x -> {
                ObjectNode result = Json.newObject();
                result.put("success", x);
                result.put("data", x);
                return ok(result);

            });
        }

        public CompletionStage<Result> getMatchById(String matchId) {

            return matchService.getMatchById(matchId).thenApplyAsync(match -> {
                ObjectNode result = Json.newObject();
                result.put("success", true);
                result.set("data", Json.toJson(match));
                return ok(Json.toJson(result));
            });
        }

    public CompletionStage<Result> getAllMatches() {

        return matchService.getAllMatches().thenApplyAsync(match -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(match));
            return ok(Json.toJson(result));
        });
    }
    }

