package com.sapient.leaguestanding.service;

import com.sapient.leaguestanding.models.Country;
import com.sapient.leaguestanding.models.League;
import com.sapient.leaguestanding.models.Standings;
import com.sapient.leaguestanding.models.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class LeagueStandingServiceTest {

    public LeagueStandingServiceTest() {
    }

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private LeagueStandingService leagueStandingService = new LeagueStandingService();

    @Test
    public void testLeagueStandingService() {
        List<Country> countries = new ArrayList<>();
        ArrayList<League> leagues = new ArrayList<>();
        ArrayList<Team> teamList = new ArrayList<>();
        int countryId = 1;
        int leagueId = 12;
        teamList.add(new Team(14, "team1", 4));
        leagues.add(new League(leagueId, "La Liga", teamList));
        Country c1 = new Country(countryId, "Spain", leagues);
        countries.add(c1);
        Mockito.when(
                restTemplate.getForEntity(leagueStandingService.getCountriesURL(), Country[].class))
                .thenReturn(
                        new ResponseEntity<Country[]>(countries.toArray(new Country[0]),
                                HttpStatus.OK));

        Mockito.when(
                restTemplate.getForEntity(leagueStandingService.getLeaguesURL() + countryId, League[].class))
                .thenReturn(new ResponseEntity<League[]>(leagues.toArray(new League[0]), HttpStatus.OK));

        List<Standings> standings = new ArrayList<>();
        Standings e = new Standings();
        e.setCountryName("France");
        e.setLeagueId(1);
        e.setLeagueName("League1");
        e.setOverallLeaguePosition("12");
        standings.add(e);

        Mockito.when(
                restTemplate.getForEntity(leagueStandingService.getStandingsURL() + leagueId, Standings[].class))
                .thenReturn(new ResponseEntity<Standings[]>(standings.toArray(new Standings[0]), HttpStatus.OK));

        List<Country> countryWiseLeagueRanking = leagueStandingService
                .getCountryWiseLeagueRanking();
        Assert.assertEquals("Spain", countryWiseLeagueRanking.get(0).getCountryName());
    }
}