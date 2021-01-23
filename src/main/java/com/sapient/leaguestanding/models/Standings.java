package com.sapient.leaguestanding.models;

/* tushar created on 23/01/21*/

import com.fasterxml.jackson.annotation.JsonProperty;

public class Standings {
    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("league_id")
    private int leagueId;

    @JsonProperty("league_name")
    private String leagueName;

    @JsonProperty("team_id")
    private int teamId;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("overall_league_position")
    private String overallLeaguePosition;

    @JsonProperty("overall_league_payed")
    private String overallLeaguePlayed;

    @JsonProperty("overall_league_W")
    private String won;

    @JsonProperty("overall_league_D")
    private String draw;

    @JsonProperty("overall_league_L")
    private String lost;

    @JsonProperty("overall_league_GF")
    private String goalFor;

    @JsonProperty("overall_league_GA")
    private String goalAgainst;

    @JsonProperty("overall_league_PTS")
    private String leaguePTS;

    @JsonProperty("home_league_position")
    private String homePos;

    @JsonProperty("home_league_payed")
    private String homeLeaguePlayed;

    @JsonProperty("home_league_W")
    private String homeWon;

    @JsonProperty("home_league_D")
    private String homeD;

    @JsonProperty("home_league_L")
    private String homeL;

    @JsonProperty("home_league_GF")
    private String homeGF;

    @JsonProperty("home_league_GA")
    private String homeGA;

    @JsonProperty("home_league_PTS")
    private String homePTS;

//    @JsonProperty("away_league_position")
//    @JsonProperty("away_league_payed")
//    @JsonProperty("away_league_W")
//    @JsonProperty("away_league_D")
//    @JsonProperty("away_league_L")
//    @JsonProperty("away_league_GF")
//    @JsonProperty("away_league_GA")
//    @JsonProperty("away_league_PTS")


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

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

    public String getOverallLeaguePosition() {
        return overallLeaguePosition;
    }

    public void setOverallLeaguePosition(String overallLeaguePosition) {
        this.overallLeaguePosition = overallLeaguePosition;
    }
}
