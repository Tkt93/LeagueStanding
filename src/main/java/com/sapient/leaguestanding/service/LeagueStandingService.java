package com.sapient.leaguestanding.service;

/* tushar created on 23/01/21*/

import com.sapient.leaguestanding.models.Country;
import com.sapient.leaguestanding.models.League;
import com.sapient.leaguestanding.models.Standings;
import com.sapient.leaguestanding.models.Team;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LeagueStandingService {

    @Value("${service.url}")
    String serviceUrl;

    @Value("${service.api.key}")
    String apiKey;

    @Autowired
    RestTemplate template;

    public List<Country> getCountryWiseLeagueRanking(){
        return getCountryWiseLeagueStanding();
    }

    private List<Country> getCountryWiseLeagueStanding() {
        List<Country> allCountry = getAllCountry();
        allCountry.forEach(c -> {
            List<League> leagues = c.getLeagues();
            leagues.forEach(league -> {
                ResponseEntity<Standings[]> en = template.getForEntity(
                        getStandingsURL() + league
                                .getLeagueId(), Standings[].class);
                List<Team> teams = Arrays.stream(Objects.requireNonNull(en.getBody()))
                        .map(standings -> new Team(standings.getTeamId(), standings.getTeamName(),
                                Integer.parseInt(standings.getOverallLeaguePosition())))
                        .sorted(Comparator.comparingInt(Team::getRanking))
                        .collect(Collectors.toList());
                league.setTeamList(teams);
            });
        });
        return allCountry;
    }

    public List<Country> getAllCountry() {
        ResponseEntity<Country[]> entity = template
                .getForEntity(getCountriesURL(), Country[].class);
        List<Country> countries = Arrays.asList(Objects.requireNonNull(entity.getBody()));
        countries.forEach(country -> {
            ResponseEntity<League[]> e = template.getForEntity(
                    getLeaguesURL() + country
                            .getCountryId(),
                    League[].class);
            country.setLeagues(Arrays.asList(Objects.requireNonNull(e.getBody())));
        });
        return countries;
    }

    protected String getServiceUrlWithKey() {
        return serviceUrl + "?APIkey=" + apiKey;
    }

    protected String getCountriesURL(){
        return getServiceUrlWithKey() + "&action=get_countries";
    }

    protected String getLeaguesURL(){
        return getServiceUrlWithKey() + "&action=get_leagues" + "&country_id=";
    }

    protected String getStandingsURL(){
        return getServiceUrlWithKey() + "&action=get_standings&league_id=";
    }
}
