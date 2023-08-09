// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {

  // @LINE:33
  class ReverseTeamSquadController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def insertTeamSquad: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TeamSquadController.insertTeamSquad",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "teamSquad/insertTeamSquad"})
        }
      """
    )
  
    // @LINE:34
    def getPlayersForMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TeamSquadController.getPlayersForMatch",
      """
        function(country10,country21) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "teamSquad/getPlayersForMatch/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("country1", country10)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("country2", country21))})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseUserTeamController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def insertUserTeam: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTeamController.insertUserTeam",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userTeam/insertUserTeam"})
        }
      """
    )
  
    // @LINE:30
    def getUserTeamById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserTeamController.getUserTeamById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userTeam/getUserTeamById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseMatchController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def insertMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MatchController.insertMatch",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "match/insertMatch"})
        }
      """
    )
  
    // @LINE:15
    def getMatchById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MatchController.getMatchById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "match/getMatchById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def getAllMatches: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MatchController.getAllMatches",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "match/getAllMatches"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseContestController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def insertContest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContestController.insertContest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "contest/insertContest"})
        }
      """
    )
  
    // @LINE:38
    def getContestById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContestController.getContestById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contest/getContestById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:39
    def getContestsByMatchId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ContestController.getContestsByMatchId",
      """
        function(matchId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contest/getContestByMatchId/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("matchId", matchId0))})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def insertCustomer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.insertCustomer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/insertUser"})
        }
      """
    )
  
    // @LINE:9
    def getUserById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getUserById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def checkIfValidLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.checkIfValidLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/checkIfValidLogin"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReversePlayerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def insertPlayer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PlayerController.insertPlayer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "player/insertPlayer"})
        }
      """
    )
  
    // @LINE:23
    def getPlayerById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PlayerController.getPlayerById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "player/getPlayerById/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:24
    def getPlayers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PlayerController.getPlayers",
      """
        function(country10,country21) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "player/getPlayersForMatch/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("country1", country10)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("country2", country21))})
        }
      """
    )
  
    // @LINE:25
    def getSelectedPlayers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PlayerController.getSelectedPlayers",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "player/getSelectedPlayers"})
        }
      """
    )
  
  }


}
