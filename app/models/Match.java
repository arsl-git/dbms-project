package models;

import java.util.UUID;

public class Match {
    private String matchId;
    private String matchName;
    private String matchDate;

    private String squadId1;
    private String squadId2;
    private String country1;
    private String country2;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Match() {

    }

    public Match(String matchId, String matchName, String matchDate, String squadId1, String squadId2, String country1, String country2) {
        this.matchId = matchId;
        this.matchName = matchName;
        this.matchDate = matchDate;
        this.squadId1 = squadId1;
        this.squadId2 = squadId2;
        this.country1 = country1;
        this.country2 = country2;

    }

    public Match(String matchName, String matchDate, String squadId1, String squadId2, String country1, String country2) {

        this.matchName = matchName;
        this.matchDate = matchDate;

        this.squadId1 = squadId1;
        this.squadId2 = squadId2;
        this.country1 = country1;
        this.country2 = country2;
    }


    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }


    public String getSquadId1() {
        return squadId1;
    }

    public void setSquadId1(String squadId1) {
        this.squadId1 = squadId1;
    }

    public String getSquadId2() {
        return squadId2;
    }

    public void setSquadId2(String squadId2) {
        this.squadId2 = squadId2;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getCountry2() {
        return country2;
    }

    public void setCountry2(String country2) {
        this.country2 = country2;
    }

    public String generateMatchId() {
        return "match_" + UUID.randomUUID();
    }
}
