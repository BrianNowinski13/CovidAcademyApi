package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.repository.StatesMetadataDbRepository;
import pl.sdaacademy.covidacademyapi.states_information.service.StatesInformationService;
import pl.sdaacademy.covidacademyapi.states_stats.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatesStatsService {

    private final CovidTrackingApi covidTrackingApi;
    private final StatesInformationService statesInformationService;
    private final StateStatsTransformer stateStatsTransformer;

    @Autowired
    public StatesStatsService(StatesInformationService statesInformationService, CovidTrackingApi covidTrackingApi, StateStatsTransformer stateStatsTransformer, StatesMetadataDbRepository statesMetadataDbRepository) {
        this.covidTrackingApi = covidTrackingApi;
        this.statesInformationService = statesInformationService;
        this.stateStatsTransformer = stateStatsTransformer;
    }

    public List<StateStatsDTO> getAllStatesCurrentStats() {
        return Arrays.stream(covidTrackingApi.getAllStatesCurrentStats())
                .map(stateCurrentStats -> {
                    StateInformation stateInformation = statesInformationService.getStateById(stateCurrentStats.getState()).get();
                    return stateStatsTransformer.stateStatsDTO(stateCurrentStats, stateInformation);
                })
                .collect(Collectors.toList());

    }

    public StateStatsDTO getCurrentState(String state, String date) {
        StateInformation stateInformation = statesInformationService.getStateByName(state)
                .orElseThrow(() -> {
                    throw new NoStateFoundException(state);
                });
        String acronym = stateInformation.getState();
        StateCurrentStats stateCurrentStats = covidTrackingApi.getSpecificStateOfStates(acronym, date);
        return stateStatsTransformer.stateStatsDTO(stateCurrentStats, stateInformation);
    }

}
