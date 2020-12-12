package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CovidTrackingApiRepository {

    public StateCurrentStats[] getAllStatesCurrentStats() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.covidtracking.com/v1/states/current.json";
        StateCurrentStats[] allStatesCurrentStats = restTemplate.getForObject(url, StateCurrentStats[].class);
        return allStatesCurrentStats;
    }
}
