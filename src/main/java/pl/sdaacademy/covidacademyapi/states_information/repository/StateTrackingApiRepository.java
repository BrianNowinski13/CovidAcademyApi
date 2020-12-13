package pl.sdaacademy.covidacademyapi.states_information.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StateTrackingApiRepository implements StateTrackingApi {

    private final RestTemplate restTemplate;

    private final String url3;

    public StateTrackingApiRepository(RestTemplate restTemplate, @Value("${covidtrackingapi.url3}") String url3) {
        this.url3 = url3;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateInformation[] getAllStatesInformation() {
        return restTemplate.getForObject(url3,StateInformation[].class);
    }

}
