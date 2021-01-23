package com.sapient.leaguestanding.models;

/* tushar created on 23/01/21*/

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Country {

    @JsonProperty("country_id")
    int countryId;

    @JsonProperty("country_name")
    String countryName;

    List<League> leagues;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", leagues=" + leagues +
                '}';
    }
}
