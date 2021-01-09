package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.service.StatesInformationService;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

import java.util.List;
import java.util.Optional;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;
    private final StatesInformationService statesInformationService;

    @Autowired
    public StatesStatsService(StatesInformationService statesInformationService, CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
        this.statesInformationService = statesInformationService;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {
        return covidTrackingApi.getAllStatesCurrentStats();
    }

    public StateCurrentStats getCurrentState(String state, String date) {
        String acronym = statesInformationService.getStateByName(state)
                .orElseThrow(() -> {
                    throw new NoStateFoundException(state);
                }).getState();

        return covidTrackingApi.getSpecificStateOfStates(acronym, date);
    }

}
