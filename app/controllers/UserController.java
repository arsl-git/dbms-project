package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Login;
import models.User;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.users.UserService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class UserController extends Controller {
    private HttpExecutionContext ec;
    private UserService userService;

    @Inject
    public UserController(UserService userService, HttpExecutionContext ec) {
        this.userService = userService;
        this.ec = ec;
    }

    public CompletionStage<Result> insertCustomer(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        User user = Json.fromJson(json, User.class);

        return userService.insertUser(user).thenApplyAsync(x -> {
            ObjectNode result = Json.newObject();
            result.put("success", x);
            result.put("data", x);
            return ok(result);

        });
    }

    public CompletionStage<Result> getUserById(String userId) {

        return userService.getUserById(userId).thenApplyAsync(user -> {
            ObjectNode result = Json.newObject();
            result.put("success", true);
            result.set("data", Json.toJson(user));
            return ok(Json.toJson(result));
        });
    }

    public CompletionStage<Result> checkIfValidLogin(Http.Request request) {
        //requested jon from post request
        JsonNode json = request.body().asJson();
        // convert json to user class/object
        Login login = Json.fromJson(json, Login.class);

        return userService.checkIfValidLogin(login).thenApplyAsync(response -> {
            ObjectNode result = Json.newObject();
            result.put("success", response);
            if (response)
                result.put("data", "valid login");
            else
                result.put("data", "invalid login!! password or email does not exist");
            return ok(result);

        });
    }
}
