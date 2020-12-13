package pl.sdaacademy.covidacademyapi.states_information.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StateTrackingApiRepository implements StateTrackingApi {

    private final RestTemplate restTemplate;

    private final String urlMetaData;

    public StateTrackingApiRepository(RestTemplate restTemplate, @Value("${covidtrackingapi.metadata.url}") String urlMetaData) {
        this.urlMetaData = urlMetaData;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateInformation[] getAllStatesInformation() {
        return restTemplate.getForObject(urlMetaData, StateInformation[].class);
    }

}
