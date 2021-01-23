package com.sapient.leaguestanding.config;

/* tushar created on 23/01/21*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LeagueStandingConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
