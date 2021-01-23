package com.sapient.leaguestanding.service;

/* tushar created on 23/01/21*/

import com.sapient.leaguestanding.models.Country;
import com.sapient.leaguestanding.repository.LeagueStandingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueStandingService {

    @Autowired
    LeagueStandingRepository leagueStandingRepository;

    public List<Country> getCountryWiseLeagueRanking(){
        return leagueStandingRepository.getCountryWiseLeagueStanding();
    }
}
