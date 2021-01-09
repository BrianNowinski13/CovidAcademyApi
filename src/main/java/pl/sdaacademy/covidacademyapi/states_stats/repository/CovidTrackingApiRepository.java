package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String urlAllStates;
    private final String urlSpecificState;

    public CovidTrackingApiRepository(RestTemplate restTemplate, @Value("${covidtrackingapi.allstates.url}") String urlAllStates, @Value("${covidtrackingapi.specificstate.url}") String urlSpecificState) {
        this.urlAllStates = urlAllStates;
        this.urlSpecificState = urlSpecificState;
        this.restTemplate = restTemplate;
    }


    @Override
    public StateCurrentStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(urlAllStates, StateCurrentStats[].class);
    }

    @Override
    public StateCurrentStats getSpecificStateOfStates(String state, String date) {
        return restTemplate.getForObject(String.format(urlSpecificState, state, date), StateCurrentStats.class);
    }


}
