package com.sapient.leaguestanding.models;

/* tushar created on 23/01/21*/

public class Team {
    int teamId;
    String teamName;

    int ranking;

    public Team(int teamId, String teamName, int ranking) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.ranking = ranking;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
