// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  UserController_5: controllers.UserController,
  // @LINE:14
  MatchController_2: controllers.MatchController,
  // @LINE:22
  PlayerController_3: controllers.PlayerController,
  // @LINE:29
  UserTeamController_1: controllers.UserTeamController,
  // @LINE:33
  TeamSquadController_4: controllers.TeamSquadController,
  // @LINE:37
  ContestController_0: controllers.ContestController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    UserController_5: controllers.UserController,
    // @LINE:14
    MatchController_2: controllers.MatchController,
    // @LINE:22
    PlayerController_3: controllers.PlayerController,
    // @LINE:29
    UserTeamController_1: controllers.UserTeamController,
    // @LINE:33
    TeamSquadController_4: controllers.TeamSquadController,
    // @LINE:37
    ContestController_0: controllers.ContestController
  ) = this(errorHandler, UserController_5, MatchController_2, PlayerController_3, UserTeamController_1, TeamSquadController_4, ContestController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_5, MatchController_2, PlayerController_3, UserTeamController_1, TeamSquadController_4, ContestController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/insertUser""", """controllers.UserController.insertCustomer(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/getUserById/""" + "$" + """id<[^/]+>""", """controllers.UserController.getUserById(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/checkIfValidLogin""", """controllers.UserController.checkIfValidLogin(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """match/insertMatch""", """controllers.MatchController.insertMatch(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """match/getMatchById/""" + "$" + """id<[^/]+>""", """controllers.MatchController.getMatchById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """match/getAllMatches""", """controllers.MatchController.getAllMatches()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """player/insertPlayer""", """controllers.PlayerController.insertPlayer(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """player/getPlayerById/""" + "$" + """id<[^/]+>""", """controllers.PlayerController.getPlayerById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """player/getPlayersForMatch/""" + "$" + """country1<[^/]+>/""" + "$" + """country2<[^/]+>""", """controllers.PlayerController.getPlayers(country1:String, country2:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """player/getSelectedPlayers""", """controllers.PlayerController.getSelectedPlayers(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userTeam/insertUserTeam""", """controllers.UserTeamController.insertUserTeam(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userTeam/getUserTeamById/""" + "$" + """id<[^/]+>""", """controllers.UserTeamController.getUserTeamById(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """teamSquad/insertTeamSquad""", """controllers.TeamSquadController.insertTeamSquad(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """teamSquad/getPlayersForMatch/""" + "$" + """country1<[^/]+>/""" + "$" + """country2<[^/]+>""", """controllers.TeamSquadController.getPlayersForMatch(country1:String, country2:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """contest/insertContest""", """controllers.ContestController.insertContest(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """contest/getContestById/""" + "$" + """id<[^/]+>""", """controllers.ContestController.getContestById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """contest/getContestByMatchId/""" + "$" + """matchId<[^/]+>""", """controllers.ContestController.getContestsByMatchId(matchId:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_UserController_insertCustomer0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/insertUser")))
  )
  private[this] lazy val controllers_UserController_insertCustomer0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_5.insertCustomer(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "insertCustomer",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """user/insertUser""",
      """----------------------------------------user Routes----------------------------------------------""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_getUserById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/getUserById/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUserById1_invoker = createInvoker(
    UserController_5.getUserById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """user/getUserById/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_checkIfValidLogin2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/checkIfValidLogin")))
  )
  private[this] lazy val controllers_UserController_checkIfValidLogin2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_5.checkIfValidLogin(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "checkIfValidLogin",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """user/checkIfValidLogin""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_MatchController_insertMatch3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("match/insertMatch")))
  )
  private[this] lazy val controllers_MatchController_insertMatch3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MatchController_2.insertMatch(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MatchController",
      "insertMatch",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """match/insertMatch""",
      """----------------------------------------matches Routes----------------------------------------------""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_MatchController_getMatchById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("match/getMatchById/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MatchController_getMatchById4_invoker = createInvoker(
    MatchController_2.getMatchById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MatchController",
      "getMatchById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """match/getMatchById/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_MatchController_getAllMatches5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("match/getAllMatches")))
  )
  private[this] lazy val controllers_MatchController_getAllMatches5_invoker = createInvoker(
    MatchController_2.getAllMatches(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MatchController",
      "getAllMatches",
      Nil,
      "GET",
      this.prefix + """match/getAllMatches""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_PlayerController_insertPlayer6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("player/insertPlayer")))
  )
  private[this] lazy val controllers_PlayerController_insertPlayer6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PlayerController_3.insertPlayer(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PlayerController",
      "insertPlayer",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """player/insertPlayer""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_PlayerController_getPlayerById7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("player/getPlayerById/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PlayerController_getPlayerById7_invoker = createInvoker(
    PlayerController_3.getPlayerById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PlayerController",
      "getPlayerById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """player/getPlayerById/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_PlayerController_getPlayers8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("player/getPlayersForMatch/"), DynamicPart("country1", """[^/]+""",true), StaticPart("/"), DynamicPart("country2", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PlayerController_getPlayers8_invoker = createInvoker(
    PlayerController_3.getPlayers(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PlayerController",
      "getPlayers",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """player/getPlayersForMatch/""" + "$" + """country1<[^/]+>/""" + "$" + """country2<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_PlayerController_getSelectedPlayers9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("player/getSelectedPlayers")))
  )
  private[this] lazy val controllers_PlayerController_getSelectedPlayers9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PlayerController_3.getSelectedPlayers(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PlayerController",
      "getSelectedPlayers",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """player/getSelectedPlayers""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_UserTeamController_insertUserTeam10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userTeam/insertUserTeam")))
  )
  private[this] lazy val controllers_UserTeamController_insertUserTeam10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserTeamController_1.insertUserTeam(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTeamController",
      "insertUserTeam",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """userTeam/insertUserTeam""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_UserTeamController_getUserTeamById11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userTeam/getUserTeamById/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserTeamController_getUserTeamById11_invoker = createInvoker(
    UserTeamController_1.getUserTeamById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserTeamController",
      "getUserTeamById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """userTeam/getUserTeamById/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_TeamSquadController_insertTeamSquad12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("teamSquad/insertTeamSquad")))
  )
  private[this] lazy val controllers_TeamSquadController_insertTeamSquad12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      TeamSquadController_4.insertTeamSquad(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TeamSquadController",
      "insertTeamSquad",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """teamSquad/insertTeamSquad""",
      """--------------------------------------teamSquad routes---------------------------------------""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_TeamSquadController_getPlayersForMatch13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("teamSquad/getPlayersForMatch/"), DynamicPart("country1", """[^/]+""",true), StaticPart("/"), DynamicPart("country2", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TeamSquadController_getPlayersForMatch13_invoker = createInvoker(
    TeamSquadController_4.getPlayersForMatch(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TeamSquadController",
      "getPlayersForMatch",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """teamSquad/getPlayersForMatch/""" + "$" + """country1<[^/]+>/""" + "$" + """country2<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_ContestController_insertContest14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contest/insertContest")))
  )
  private[this] lazy val controllers_ContestController_insertContest14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ContestController_0.insertContest(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ContestController",
      "insertContest",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """contest/insertContest""",
      """---------------------------------------contest rotes------------------------------------------""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_ContestController_getContestById15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contest/getContestById/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ContestController_getContestById15_invoker = createInvoker(
    ContestController_0.getContestById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ContestController",
      "getContestById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """contest/getContestById/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_ContestController_getContestsByMatchId16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("contest/getContestByMatchId/"), DynamicPart("matchId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ContestController_getContestsByMatchId16_invoker = createInvoker(
    ContestController_0.getContestsByMatchId(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ContestController",
      "getContestsByMatchId",
      Seq(classOf[String]),
      "GET",
      this.prefix + """contest/getContestByMatchId/""" + "$" + """matchId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_UserController_insertCustomer0_route(params@_) =>
      call { 
        controllers_UserController_insertCustomer0_invoker.call(
          req => UserController_5.insertCustomer(req))
      }
  
    // @LINE:9
    case controllers_UserController_getUserById1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_getUserById1_invoker.call(UserController_5.getUserById(id))
      }
  
    // @LINE:10
    case controllers_UserController_checkIfValidLogin2_route(params@_) =>
      call { 
        controllers_UserController_checkIfValidLogin2_invoker.call(
          req => UserController_5.checkIfValidLogin(req))
      }
  
    // @LINE:14
    case controllers_MatchController_insertMatch3_route(params@_) =>
      call { 
        controllers_MatchController_insertMatch3_invoker.call(
          req => MatchController_2.insertMatch(req))
      }
  
    // @LINE:15
    case controllers_MatchController_getMatchById4_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_MatchController_getMatchById4_invoker.call(MatchController_2.getMatchById(id))
      }
  
    // @LINE:16
    case controllers_MatchController_getAllMatches5_route(params@_) =>
      call { 
        controllers_MatchController_getAllMatches5_invoker.call(MatchController_2.getAllMatches())
      }
  
    // @LINE:22
    case controllers_PlayerController_insertPlayer6_route(params@_) =>
      call { 
        controllers_PlayerController_insertPlayer6_invoker.call(
          req => PlayerController_3.insertPlayer(req))
      }
  
    // @LINE:23
    case controllers_PlayerController_getPlayerById7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_PlayerController_getPlayerById7_invoker.call(PlayerController_3.getPlayerById(id))
      }
  
    // @LINE:24
    case controllers_PlayerController_getPlayers8_route(params@_) =>
      call(params.fromPath[String]("country1", None), params.fromPath[String]("country2", None)) { (country1, country2) =>
        controllers_PlayerController_getPlayers8_invoker.call(PlayerController_3.getPlayers(country1, country2))
      }
  
    // @LINE:25
    case controllers_PlayerController_getSelectedPlayers9_route(params@_) =>
      call { 
        controllers_PlayerController_getSelectedPlayers9_invoker.call(
          req => PlayerController_3.getSelectedPlayers(req))
      }
  
    // @LINE:29
    case controllers_UserTeamController_insertUserTeam10_route(params@_) =>
      call { 
        controllers_UserTeamController_insertUserTeam10_invoker.call(
          req => UserTeamController_1.insertUserTeam(req))
      }
  
    // @LINE:30
    case controllers_UserTeamController_getUserTeamById11_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserTeamController_getUserTeamById11_invoker.call(UserTeamController_1.getUserTeamById(id))
      }
  
    // @LINE:33
    case controllers_TeamSquadController_insertTeamSquad12_route(params@_) =>
      call { 
        controllers_TeamSquadController_insertTeamSquad12_invoker.call(
          req => TeamSquadController_4.insertTeamSquad(req))
      }
  
    // @LINE:34
    case controllers_TeamSquadController_getPlayersForMatch13_route(params@_) =>
      call(params.fromPath[String]("country1", None), params.fromPath[String]("country2", None)) { (country1, country2) =>
        controllers_TeamSquadController_getPlayersForMatch13_invoker.call(TeamSquadController_4.getPlayersForMatch(country1, country2))
      }
  
    // @LINE:37
    case controllers_ContestController_insertContest14_route(params@_) =>
      call { 
        controllers_ContestController_insertContest14_invoker.call(
          req => ContestController_0.insertContest(req))
      }
  
    // @LINE:38
    case controllers_ContestController_getContestById15_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ContestController_getContestById15_invoker.call(ContestController_0.getContestById(id))
      }
  
    // @LINE:39
    case controllers_ContestController_getContestsByMatchId16_route(params@_) =>
      call(params.fromPath[String]("matchId", None)) { (matchId) =>
        controllers_ContestController_getContestsByMatchId16_invoker.call(ContestController_0.getContestsByMatchId(matchId))
      }
  }
}
