// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:33
  class ReverseTeamSquadController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def insertTeamSquad(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "teamSquad/insertTeamSquad")
    }
  
    // @LINE:34
    def getPlayersForMatch(country1:String, country2:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "teamSquad/getPlayersForMatch/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("country1", country1)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("country2", country2)))
    }
  
  }

  // @LINE:29
  class ReverseUserTeamController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def insertUserTeam(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "userTeam/insertUserTeam")
    }
  
    // @LINE:30
    def getUserTeamById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userTeam/getUserTeamById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:14
  class ReverseMatchController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def insertMatch(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "match/insertMatch")
    }
  
    // @LINE:15
    def getMatchById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "match/getMatchById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:16
    def getAllMatches(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "match/getAllMatches")
    }
  
  }

  // @LINE:37
  class ReverseContestController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def insertContest(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "contest/insertContest")
    }
  
    // @LINE:38
    def getContestById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "contest/getContestById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:39
    def getContestsByMatchId(matchId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "contest/getContestByMatchId/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("matchId", matchId)))
    }
  
  }

  // @LINE:8
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def insertCustomer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user/insertUser")
    }
  
    // @LINE:9
    def getUserById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/getUserById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:10
    def checkIfValidLogin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user/checkIfValidLogin")
    }
  
  }

  // @LINE:22
  class ReversePlayerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def insertPlayer(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "player/insertPlayer")
    }
  
    // @LINE:23
    def getPlayerById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "player/getPlayerById/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:24
    def getPlayers(country1:String, country2:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "player/getPlayersForMatch/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("country1", country1)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("country2", country2)))
    }
  
    // @LINE:25
    def getSelectedPlayers(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "player/getSelectedPlayers")
    }
  
  }


}
