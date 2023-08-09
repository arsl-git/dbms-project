package models;

import java.util.UUID;

public class Contest {
    private String contestName;
    private String contestId;
    private int contestAmt;
    private long winningAmt;
    private String matchId;

    private int firstPrize;

    private String contestType;
    public Contest() {

    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public int getContestAmt() {
        return contestAmt;
    }

    public void setContestAmt(int contestAmt) {
        this.contestAmt = contestAmt;
    }

    public long getWinningAmt() {
        return winningAmt;
    }

    public void setWinningAmt(long winningAmt) {
        this.winningAmt = winningAmt;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getFirstPrize() {
        return firstPrize;
    }

    public void setFirstPrize(int firstPrize) {
        this.firstPrize = firstPrize;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public Contest(String contestName, String contestId, int contestAmt, long winningAmt, String matchId,int firstPrize,String contestType) {
        this.contestName = contestName;
        this.contestId = contestId;
        this.contestAmt = contestAmt;
        this.winningAmt = winningAmt;
        this.matchId = matchId;
        this.firstPrize = firstPrize;
        this.contestType = contestType;
    }

    public Contest(String contestName, int contestAmt, long winningAmt, String matchId,int firstPrize,String contestType) {

        this.contestName = contestName;
        this.contestAmt = contestAmt;
        this.winningAmt = winningAmt;
        this.matchId = matchId;
        this.firstPrize = firstPrize;
        this.contestType = contestType;
    }



    public String generateContestId() {
        return "contest_" + UUID.randomUUID();
    }
}
