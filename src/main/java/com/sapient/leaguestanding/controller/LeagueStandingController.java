package com.sapient.leaguestanding.controller;

/* tushar created on 23/01/21*/

import com.sapient.leaguestanding.models.Country;
import com.sapient.leaguestanding.service.LeagueStandingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeagueStandingController {

    @Autowired
    LeagueStandingService leagueStandingService;

    @RequestMapping(value = "/league/standing/all")
    public List<Country> getCountryWiseLeagueRanking(){
        return leagueStandingService.getCountryWiseLeagueRanking();
    }
}
