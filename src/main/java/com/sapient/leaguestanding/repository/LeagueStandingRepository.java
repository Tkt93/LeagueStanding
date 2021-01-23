package com.sapient.leaguestanding.repository;

/* tushar created on 23/01/21*/

import com.sapient.leaguestanding.models.Country;
import com.sapient.leaguestanding.models.League;
import java.util.List;

public interface LeagueStandingRepository {

     List<League> getLeaguesByCountry(int countryId);

     List<Country> getAllCountry();

     List<Country> getCountryWiseLeagueStanding();

}
