// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTeamSquadController TeamSquadController = new controllers.ReverseTeamSquadController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserTeamController UserTeamController = new controllers.ReverseUserTeamController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMatchController MatchController = new controllers.ReverseMatchController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseContestController ContestController = new controllers.ReverseContestController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePlayerController PlayerController = new controllers.ReversePlayerController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTeamSquadController TeamSquadController = new controllers.javascript.ReverseTeamSquadController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserTeamController UserTeamController = new controllers.javascript.ReverseUserTeamController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMatchController MatchController = new controllers.javascript.ReverseMatchController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseContestController ContestController = new controllers.javascript.ReverseContestController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePlayerController PlayerController = new controllers.javascript.ReversePlayerController(RoutesPrefix.byNamePrefix());
  }

}
