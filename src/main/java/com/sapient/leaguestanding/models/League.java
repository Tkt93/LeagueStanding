package com.sapient.leaguestanding.models;

/* tushar created on 23/01/21*/

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class League {
    @JsonProperty("league_id")
    int leagueId;

    @JsonProperty("league_name")
    String leagueName;

    List<Team> teamList;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public League() {
    }

    public League(int leagueId, String leagueName,
            List<Team> teamList) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
