package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Contest;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.contests.ContestService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class ContestController extends Controller {

    private HttpExecutionContext ec;
    private ContestService contestService;

    @Inject
    public ContestController(ContestService contestService, HttpExecutionContext ec) {
        this.contestService = contestService;
        this.ec = ec;
    }

    public CompletionStage<Result> insertContest(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        Contest contest = Json.fromJson(json, Contest.class);

        return contestService.insertContest(contest).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", x);
            result.put("data", x);
            return ok(result);

        });
    }

    public CompletionStage<Result> getContestById(String contestId) {

        return contestService.getContestById(contestId).thenApplyAsync(contest -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(contest));
            return ok(Json.toJson(result));
        });
    }

    public CompletionStage<Result> getContestsByMatchId(String matchId) {

        return contestService.getContestByMatchId(matchId).thenApplyAsync(contest -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(contest));
            return ok(Json.toJson(result));
        });
    }

}
