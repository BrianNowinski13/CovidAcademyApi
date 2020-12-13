package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApiRepository;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

import java.util.Date;

@Service
public class StatesStatsService {

    private CovidTrackingApi covidTrackingApi;

    public StatesStatsService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {
        return covidTrackingApi.getAllStatesCurrentStats();
    }
    public StateCurrentStats getSpecificStateOfStates(String state, String date) {
        return covidTrackingApi.getSpecificStateOfStates(state,date);
    }


}
