package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.service.StatesInformationService;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;
import pl.sdaacademy.covidacademyapi.states_stats.web.ErrorHandler;

import java.util.List;

@Service
public class StatesStatsService {

    private CovidTrackingApi covidTrackingApi;
    private StatesInformationService statesInformationService;

    @Autowired
    public StatesStatsService(StatesInformationService statesInformationService,CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
        this.statesInformationService = statesInformationService;
    }

    public StateCurrentStats[] getAllStatesCurrentStats() {
        return covidTrackingApi.getAllStatesCurrentStats();
    }

    public StateCurrentStats getCurrentState(String state, String date) {
        //tutaj musimy z mapować nazwe stanu na akronim
        List<StateInformation> statesInformationServiceList = statesInformationService.getAllStatesInformation();
         String acronym = statesInformationServiceList.stream().filter(metadata -> metadata.getName().equalsIgnoreCase(state))
                .map(metadate -> metadate.getState())
                .findAny().orElseThrow(() ->{throw new NoStateFoundException(state);});

        return covidTrackingApi.getSpecificStateOfStates(acronym, date);
    }

}
