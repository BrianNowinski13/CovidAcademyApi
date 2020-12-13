package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final RestTemplate restTemplate;
    private final String url1;
    private final String url2;
    private final String url3;

    public CovidTrackingApiRepository(RestTemplate restTemplate, @Value("${covidtrackingapi.url1}") String url1, @Value("${covidtrackingapi.url2}") String url2, @Value("${covidtrackingapi.url3}") String url3) {
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.restTemplate = restTemplate;
    }



    @Override
    public StateCurrentStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(url1, StateCurrentStats[].class);
    }

    @Override
    public StateCurrentStats getSpecificStateOfStates(String state, String date) {
        return restTemplate.getForObject(String.format(url2, state, date), StateCurrentStats.class);
    }

    @Override
    public StateInformation[] getAllStatesInformation() {
        return restTemplate.getForObject(url3,StateInformation[].class);
    }

}
