package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String url1;
    private final String url2;

    public CovidTrackingApiRepository(RestTemplate restTemplate,@Value("${covidtrackingapi.url1}") String url1, @Value("${covidtrackingapi.ur2l}") String url2) {
        this.url1 = url1;
        this.url2 = url2;
        this.restTemplate = restTemplate;
    }


    @Override
    public StateCurrentStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(url1, StateCurrentStats[].class);
    }

    @Override
    public StateCurrentStats getSpecificStateOfStates(String state, String date) {
        return restTemplate.getForObject(url2, StateCurrentStats.class);
    }
}
