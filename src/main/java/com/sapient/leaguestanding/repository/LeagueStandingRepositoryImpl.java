package com.sapient.leaguestanding.repository;

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
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LeagueStandingRepositoryImpl implements LeagueStandingRepository {

    @Value("${service.url}")
    String serviceUrl;

    @Value("${service.api.key}")
    String apiKey;

    @Autowired
    RestTemplate template;

    @Override
    public List<League> getLeaguesByCountry(int countryId) {
        List<Country> allCountry = getAllCountry();
        allCountry.forEach(country -> {
            ResponseEntity<League[]> entity = template
                    .getForEntity(getServiceUrlWithKey(), League[].class);
            country.setLeagues(Arrays.asList(Objects.requireNonNull(entity.getBody())));
        });
        return null;
    }

    @Override
    public List<Country> getAllCountry() {
        ResponseEntity<Country[]> entity = template
                .getForEntity(getServiceUrlWithKey() + "&action=get_countries", Country[].class);
        List<Country> countries = Arrays.asList(Objects.requireNonNull(entity.getBody()));
        countries.forEach(country -> {
            ResponseEntity<League[]> e = template.getForEntity(
                    getServiceUrlWithKey() + "&action=get_leagues" + "&country_id=" + country
                            .getCountryId(),
                    League[].class);
            country.setLeagues(Arrays.asList(Objects.requireNonNull(e.getBody())));
        });
        return countries;
    }

    @Override
    public List<Country> getCountryWiseLeagueStanding() {
        List<Country> allCountry = getAllCountry();
        allCountry.forEach(c -> {
            List<League> leagues = c.getLeagues();
            leagues.forEach(league -> {
                ResponseEntity<Standings[]> en = template.getForEntity(
                        getServiceUrlWithKey() + "&action=get_standings&league_id=" + league
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

    private String getServiceUrlWithKey() {
        return serviceUrl + "?APIkey=" + apiKey;
    }
}
